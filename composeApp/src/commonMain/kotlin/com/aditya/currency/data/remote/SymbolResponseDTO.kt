package com.aditya.currency.data.remote


import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.double
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

// Define the data class for exchange rates
@Serializable(with = CurrencySerializer::class)
data class SymbolResponseDTO(
    val date: String,
    val currency: Map<String, Double>
)

object CurrencySerializer : KSerializer<SymbolResponseDTO> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("SymbolResponseDTO") {
        element<String>("date")
        element<Map<String, Double>>("currency")
    }

    override fun serialize(encoder: Encoder, value: SymbolResponseDTO) {
        val jsonEncoder = encoder as? JsonEncoder
            ?: throw SerializationException("This class can be serialized only by JSON")

        // Build the JSON object
        val jsonObject = buildJsonObject {
            put("date", JsonPrimitive(value.date))
            put("currency", JsonObject(value.currency.mapValues { JsonPrimitive(it.value) }))
        }

        jsonEncoder.encodeJsonElement(jsonObject)
    }

    override fun deserialize(decoder: Decoder): SymbolResponseDTO {
        val jsonDecoder = decoder as? JsonDecoder
            ?: throw SerializationException("This class can be deserialized only by JSON")

        val jsonObject = jsonDecoder.decodeJsonElement().jsonObject

        // Extract the date
        val date = jsonObject["date"]?.jsonPrimitive?.content
            ?: throw SerializationException("Missing 'date' field")

        // Exclude 'date' from keys
        val otherKeys = jsonObject.filterKeys { it != "date" }

        if (otherKeys.isEmpty()) {
            throw SerializationException("No currency found")
        }

        // Assuming there's only one currency code per JSON object
        val (currencyCode, currencyJsonElement) = otherKeys.entries.first()

        // Extract the rates map
        val currency = currencyJsonElement.jsonObject.mapValues { (_, jsonElement) ->
            jsonElement.jsonPrimitive.double
        }

        return SymbolResponseDTO(date, currency)
    }
}