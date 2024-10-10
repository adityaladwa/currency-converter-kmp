package com.aditya.currency.domain

import currency_converter.composeapp.generated.resources.Res
import currency_converter.composeapp.generated.resources.afghanistan
import currency_converter.composeapp.generated.resources.albania
import currency_converter.composeapp.generated.resources.algeria
import currency_converter.composeapp.generated.resources.angola
import currency_converter.composeapp.generated.resources.argentina
import currency_converter.composeapp.generated.resources.armenia
import currency_converter.composeapp.generated.resources.australia
import currency_converter.composeapp.generated.resources.azerbaijan
import currency_converter.composeapp.generated.resources.bahamas
import currency_converter.composeapp.generated.resources.bahrain
import currency_converter.composeapp.generated.resources.bangladesh
import currency_converter.composeapp.generated.resources.barbados
import currency_converter.composeapp.generated.resources.belarus
import currency_converter.composeapp.generated.resources.belize
import currency_converter.composeapp.generated.resources.bermuda
import currency_converter.composeapp.generated.resources.bhutan
import currency_converter.composeapp.generated.resources.bolivia
import currency_converter.composeapp.generated.resources.bosnia_and_herzegovina
import currency_converter.composeapp.generated.resources.botswana
import currency_converter.composeapp.generated.resources.brazil
import currency_converter.composeapp.generated.resources.bulgaria
import currency_converter.composeapp.generated.resources.cambodia
import currency_converter.composeapp.generated.resources.canada
import currency_converter.composeapp.generated.resources.cape_verde
import currency_converter.composeapp.generated.resources.central_african_republic
import currency_converter.composeapp.generated.resources.chile
import currency_converter.composeapp.generated.resources.china
import currency_converter.composeapp.generated.resources.colombia
import currency_converter.composeapp.generated.resources.comoros
import currency_converter.composeapp.generated.resources.costa_rica
import currency_converter.composeapp.generated.resources.croatia
import currency_converter.composeapp.generated.resources.cuba
import currency_converter.composeapp.generated.resources.czech_republic
import currency_converter.composeapp.generated.resources.democratic_republic_of_congo
import currency_converter.composeapp.generated.resources.denmark
import currency_converter.composeapp.generated.resources.djibouti
import currency_converter.composeapp.generated.resources.dominican_republic
import currency_converter.composeapp.generated.resources.egypt
import currency_converter.composeapp.generated.resources.el_salvador
import currency_converter.composeapp.generated.resources.eritrea
import currency_converter.composeapp.generated.resources.ethiopia
import currency_converter.composeapp.generated.resources.european_union
import currency_converter.composeapp.generated.resources.falkland_islands
import currency_converter.composeapp.generated.resources.fiji
import currency_converter.composeapp.generated.resources.gambia
import currency_converter.composeapp.generated.resources.georgia
import currency_converter.composeapp.generated.resources.ghana
import currency_converter.composeapp.generated.resources.gibraltar
import currency_converter.composeapp.generated.resources.guatemala
import currency_converter.composeapp.generated.resources.guernsey
import currency_converter.composeapp.generated.resources.guinea
import currency_converter.composeapp.generated.resources.guyana
import currency_converter.composeapp.generated.resources.haiti
import currency_converter.composeapp.generated.resources.honduras
import currency_converter.composeapp.generated.resources.hong_kong
import currency_converter.composeapp.generated.resources.hungary
import currency_converter.composeapp.generated.resources.iceland
import currency_converter.composeapp.generated.resources.india
import currency_converter.composeapp.generated.resources.indonesia
import currency_converter.composeapp.generated.resources.iran
import currency_converter.composeapp.generated.resources.iraq
import currency_converter.composeapp.generated.resources.isle_of_man
import currency_converter.composeapp.generated.resources.israel
import currency_converter.composeapp.generated.resources.jamaica
import currency_converter.composeapp.generated.resources.japan
import currency_converter.composeapp.generated.resources.jersey
import currency_converter.composeapp.generated.resources.jordan
import currency_converter.composeapp.generated.resources.kazakhstan
import currency_converter.composeapp.generated.resources.kenya
import currency_converter.composeapp.generated.resources.kuwait
import currency_converter.composeapp.generated.resources.kyrgyzstan
import currency_converter.composeapp.generated.resources.laos
import currency_converter.composeapp.generated.resources.lebanon
import currency_converter.composeapp.generated.resources.lesotho
import currency_converter.composeapp.generated.resources.liberia
import currency_converter.composeapp.generated.resources.libya
import currency_converter.composeapp.generated.resources.lithuania
import currency_converter.composeapp.generated.resources.macao
import currency_converter.composeapp.generated.resources.madagascar
import currency_converter.composeapp.generated.resources.malawi
import currency_converter.composeapp.generated.resources.malaysia
import currency_converter.composeapp.generated.resources.maldives
import currency_converter.composeapp.generated.resources.mauritania
import currency_converter.composeapp.generated.resources.mauritius
import currency_converter.composeapp.generated.resources.mexico
import currency_converter.composeapp.generated.resources.moldova
import currency_converter.composeapp.generated.resources.mongolia
import currency_converter.composeapp.generated.resources.morocco
import currency_converter.composeapp.generated.resources.mozambique
import currency_converter.composeapp.generated.resources.myanmar
import currency_converter.composeapp.generated.resources.namibia
import currency_converter.composeapp.generated.resources.nepal
import currency_converter.composeapp.generated.resources.netherlands
import currency_converter.composeapp.generated.resources.new_zealand
import currency_converter.composeapp.generated.resources.nicaragua
import currency_converter.composeapp.generated.resources.nigeria
import currency_converter.composeapp.generated.resources.north_korea
import currency_converter.composeapp.generated.resources.north_macedonia
import currency_converter.composeapp.generated.resources.norway
import currency_converter.composeapp.generated.resources.oman
import currency_converter.composeapp.generated.resources.pakistan
import currency_converter.composeapp.generated.resources.panama
import currency_converter.composeapp.generated.resources.papua_new_guinea
import currency_converter.composeapp.generated.resources.paraguay
import currency_converter.composeapp.generated.resources.philippines
import currency_converter.composeapp.generated.resources.poland
import currency_converter.composeapp.generated.resources.qatar
import currency_converter.composeapp.generated.resources.romania
import currency_converter.composeapp.generated.resources.russia
import currency_converter.composeapp.generated.resources.rwanda
import currency_converter.composeapp.generated.resources.samoa
import currency_converter.composeapp.generated.resources.sao_tome_and_prince
import currency_converter.composeapp.generated.resources.saudi_arabia
import currency_converter.composeapp.generated.resources.serbia
import currency_converter.composeapp.generated.resources.seychelles
import currency_converter.composeapp.generated.resources.sierra_leone
import currency_converter.composeapp.generated.resources.singapore
import currency_converter.composeapp.generated.resources.solomon_islands
import currency_converter.composeapp.generated.resources.somalia
import currency_converter.composeapp.generated.resources.south_africa
import currency_converter.composeapp.generated.resources.south_korea
import currency_converter.composeapp.generated.resources.sri_lanka
import currency_converter.composeapp.generated.resources.sudan
import currency_converter.composeapp.generated.resources.suriname
import currency_converter.composeapp.generated.resources.sweden
import currency_converter.composeapp.generated.resources.switzerland
import currency_converter.composeapp.generated.resources.syria
import currency_converter.composeapp.generated.resources.taiwan
import currency_converter.composeapp.generated.resources.tajikistan
import currency_converter.composeapp.generated.resources.tanzania
import currency_converter.composeapp.generated.resources.thailand
import currency_converter.composeapp.generated.resources.tonga
import currency_converter.composeapp.generated.resources.trinidad_and_tobago
import currency_converter.composeapp.generated.resources.tunisia
import currency_converter.composeapp.generated.resources.turkey
import currency_converter.composeapp.generated.resources.turkmenistan
import currency_converter.composeapp.generated.resources.ukraine
import currency_converter.composeapp.generated.resources.united_arab_emirates
import currency_converter.composeapp.generated.resources.united_kingdom
import currency_converter.composeapp.generated.resources.united_states
import currency_converter.composeapp.generated.resources.uzbekista_n
import currency_converter.composeapp.generated.resources.vanuatu
import currency_converter.composeapp.generated.resources.venezuela
import currency_converter.composeapp.generated.resources.vietnam
import currency_converter.composeapp.generated.resources.yemen
import currency_converter.composeapp.generated.resources.zambia
import currency_converter.composeapp.generated.resources.zimbabwe
import org.jetbrains.compose.resources.DrawableResource

enum class CurrencyCode(
    val country: String,
    val flag: DrawableResource
) {
    AED(country = "United Arab Emirates", flag = Res.drawable.united_arab_emirates),
    AFN(country = "Afghanistan", flag = Res.drawable.afghanistan),
    ALL(country = "Albania", flag = Res.drawable.albania),
    AMD(country = "Armenia", flag = Res.drawable.armenia),
    ANG(country = "Netherlands", flag = Res.drawable.netherlands),
    AOA(country = "Angola", flag = Res.drawable.angola),
    ARS(country = "Argentina", flag = Res.drawable.argentina),
    AUD(country = "Australia", flag = Res.drawable.australia),
    AZN(country = "Azerbaijan", flag = Res.drawable.azerbaijan),
    BAM(country = "Bosnia and Herzegovina", flag = Res.drawable.bosnia_and_herzegovina),
    BBD(country = "Barbados", flag = Res.drawable.barbados),
    BDT(country = "Bangladesh", flag = Res.drawable.bangladesh),
    BGN(country = "Bulgaria", flag = Res.drawable.bulgaria),
    BHD(country = "Bahrain", flag = Res.drawable.bahrain),
    BMD(country = "Bermuda", flag = Res.drawable.bermuda),
    BOB(country = "Bolivia", flag = Res.drawable.bolivia),
    BRL(country = "Brazil", flag = Res.drawable.brazil),
    BSD(country = "Bahamas", flag = Res.drawable.bahamas),
    BTN(country = "Bhutan", flag = Res.drawable.bhutan),
    BWP(country = "Botswana", flag = Res.drawable.botswana),
    BYN(country = "Belarus", flag = Res.drawable.belarus),
    BZD(country = "Belize", flag = Res.drawable.belize),
    CAD(country = "Canada", flag = Res.drawable.canada),
    CDF(country = "Democratic Republic of Congo", flag = Res.drawable.democratic_republic_of_congo),
    CHF(country = "Switzerland", flag = Res.drawable.switzerland),
    CLF(country = "Chile (Unidad de Fomento)", flag = Res.drawable.chile),
    CLP(country = "Chile", flag = Res.drawable.chile),
    CNY(country = "China", flag = Res.drawable.china),
    COP(country = "Colombia", flag = Res.drawable.colombia),
    CRC(country = "Costa Rica", flag = Res.drawable.costa_rica),
    CUC(country = "Cuba (Convertible Peso)", flag = Res.drawable.cuba),
    CUP(country = "Cuba (Cuban Peso)", flag = Res.drawable.cuba),
    CVE(country = "Cape Verde", flag = Res.drawable.cape_verde),
    CZK(country = "Czech Republic", flag = Res.drawable.czech_republic),
    DJF(country = "Djibouti", flag = Res.drawable.djibouti),
    DKK(country = "Denmark", flag = Res.drawable.denmark),
    DOP(country = "Dominican Republic", flag = Res.drawable.dominican_republic),
    DZD(country = "Algeria", flag = Res.drawable.algeria),
    EGP(country = "Egypt", flag = Res.drawable.egypt),
    ERN(country = "Eritrea", flag = Res.drawable.eritrea),
    ETB(country = "Ethiopia", flag = Res.drawable.ethiopia),
    EUR(country = "European Union", flag = Res.drawable.european_union),
    FJD(country = "Fiji", flag = Res.drawable.fiji),
    FKP(country = "Falkland Islands", flag = Res.drawable.falkland_islands),
    GBP(country = "United Kingdom", flag = Res.drawable.united_kingdom),
    GEL(country = "Georgia", flag = Res.drawable.georgia),
    GGP(country = "Guernsey", flag = Res.drawable.guernsey),
    GHS(country = "Ghana", flag = Res.drawable.ghana),
    GIP(country = "Gibraltar", flag = Res.drawable.gibraltar),
    GMD(country = "Gambia", flag = Res.drawable.gambia),
    GNF(country = "Guinea", flag = Res.drawable.guinea),
    GTQ(country = "Guatemala", flag = Res.drawable.guatemala),
    GYD(country = "Guyana", flag = Res.drawable.guyana),
    HKD(country = "Hong Kong", flag = Res.drawable.hong_kong),
    HNL(country = "Honduras", flag = Res.drawable.honduras),
    HRK(country = "Croatia", flag = Res.drawable.croatia),
    HTG(country = "Haiti", flag = Res.drawable.haiti),
    HUF(country = "Hungary", flag = Res.drawable.hungary),
    IDR(country = "Indonesia", flag = Res.drawable.indonesia),
    ILS(country = "Israel", flag = Res.drawable.israel),
    IMP(country = "Isle of Man", flag = Res.drawable.isle_of_man),
    INR(country = "India", flag = Res.drawable.india),
    IQD(country = "Iraq", flag = Res.drawable.iraq),
    IRR(country = "Iran", flag = Res.drawable.iran),
    ISK(country = "Iceland", flag = Res.drawable.iceland),
    JEP(country = "Jersey", flag = Res.drawable.jersey),
    JMD(country = "Jamaica", flag = Res.drawable.jamaica),
    JOD(country = "Jordan", flag = Res.drawable.jordan),
    JPY(country = "Japan", flag = Res.drawable.japan),
    KES(country = "Kenya", flag = Res.drawable.kenya),
    KGS(country = "Kyrgyzstan", flag = Res.drawable.kyrgyzstan),
    KHR(country = "Cambodia", flag = Res.drawable.cambodia),
    KMF(country = "Comoros", flag = Res.drawable.comoros),
    KPW(country = "North Korea", flag = Res.drawable.north_korea),
    KRW(country = "South Korea", flag = Res.drawable.south_korea),
    KWD(country = "Kuwait", flag = Res.drawable.kuwait),
    KZT(country = "Kazakhstan", flag = Res.drawable.kazakhstan),
    LAK(country = "Laos", flag = Res.drawable.laos),
    LBP(country = "Lebanon", flag = Res.drawable.lebanon),
    LKR(country = "Sri Lanka", flag = Res.drawable.sri_lanka),
    LRD(country = "Liberia", flag = Res.drawable.liberia),
    LSL(country = "Lesotho", flag = Res.drawable.lesotho),
    LTL(country = "Lithuania", flag = Res.drawable.lithuania),
    LYD(country = "Libya", flag = Res.drawable.libya),
    MAD(country = "Morocco", flag = Res.drawable.morocco),
    MDL(country = "Moldova", flag = Res.drawable.moldova),
    MGA(country = "Madagascar", flag = Res.drawable.madagascar),
    MKD(country = "North Macedonia", flag = Res.drawable.north_macedonia),
    MMK(country = "Myanmar", flag = Res.drawable.myanmar),
    MNT(country = "Mongolia", flag = Res.drawable.mongolia),
    MOP(country = "Macao", flag = Res.drawable.macao),
    MRO(country = "Mauritania", flag = Res.drawable.mauritania),
    MRU(country = "Mauritius", flag = Res.drawable.mauritius),
    MUR(country = "Mauritius", flag = Res.drawable.mauritius),
    MVR(country = "Maldives", flag = Res.drawable.maldives),
    MWK(country = "Malawi", flag = Res.drawable.malawi),
    MXN(country = "Mexico", flag = Res.drawable.mexico),
    MYR(country = "Malaysia", flag = Res.drawable.malaysia),
    MZN(country = "Mozambique", flag = Res.drawable.mozambique),
    NAD(country = "Namibia", flag = Res.drawable.namibia),
    NGN(country = "Nigeria", flag = Res.drawable.nigeria),
    NIO(country = "Nicaragua", flag = Res.drawable.nicaragua),
    NOK(country = "Norway", flag = Res.drawable.norway),
    NPR(country = "Nepal", flag = Res.drawable.nepal),
    NZD(country = "New Zealand", flag = Res.drawable.new_zealand),
    OMR(country = "Oman", flag = Res.drawable.oman),
    PAB(country = "Panama", flag = Res.drawable.panama),
    PGK(country = "Papua New Guinea", flag = Res.drawable.papua_new_guinea),
    PHP(country = "Philippines", flag = Res.drawable.philippines),
    PKR(country = "Pakistan", flag = Res.drawable.pakistan),
    PLN(country = "Poland", flag = Res.drawable.poland),
    PYG(country = "Paraguay", flag = Res.drawable.paraguay),
    QAR(country = "Qatar", flag = Res.drawable.qatar),
    RON(country = "Romania", flag = Res.drawable.romania),
    RSD(country = "Serbia", flag = Res.drawable.serbia),
    RUB(country = "Russia", flag = Res.drawable.russia),
    RWF(country = "Rwanda", flag = Res.drawable.rwanda),
    SAR(country = "Saudi Arabia", flag = Res.drawable.saudi_arabia),
    SBD(country = "Solomon Islands", flag = Res.drawable.solomon_islands),
    SCR(country = "Seychelles", flag = Res.drawable.seychelles),
    SDG(country = "Sudan", flag = Res.drawable.sudan),
    SEK(country = "Sweden", flag = Res.drawable.sweden),
    SGD(country = "Singapore", flag = Res.drawable.singapore),
    SLL(country = "Sierra Leone", flag = Res.drawable.sierra_leone),
    SOS(country = "Somalia", flag = Res.drawable.somalia),
    SRD(country = "Suriname", flag = Res.drawable.suriname),
    STD(country = "São Tomé and Príncipe", flag = Res.drawable.sao_tome_and_prince),
    STN(country = "São Tomé and Príncipe", flag = Res.drawable.sao_tome_and_prince),
    SVC(country = "El Salvador", flag = Res.drawable.el_salvador),
    SYP(country = "Syria", flag = Res.drawable.syria),
    THB(country = "Thailand", flag = Res.drawable.thailand),
    TJS(country = "Tajikistan", flag = Res.drawable.tajikistan),
    TMT(country = "Turkmenistan", flag = Res.drawable.turkmenistan),
    TND(country = "Tunisia", flag = Res.drawable.tunisia),
    TOP(country = "Tonga", flag = Res.drawable.tonga),
    TRY(country = "Turkiye", flag = Res.drawable.turkey),
    TTD(country = "Trinidad and Tobago", flag = Res.drawable.trinidad_and_tobago),
    TWD(country = "Taiwan", flag = Res.drawable.taiwan),
    TZS(country = "Tanzania", flag = Res.drawable.tanzania),
    UAH(country = "Ukraine", flag = Res.drawable.ukraine),
    USD(country = "United States of America", flag = Res.drawable.united_states),
    UZS(country = "Uzbekistan", flag = Res.drawable.uzbekista_n),
    VES(country = "Venezuela", flag = Res.drawable.venezuela),
    VND(country = "Vietnam", flag = Res.drawable.vietnam),
    VUV(country = "Vanuatu", flag = Res.drawable.vanuatu),
    WST(country = "Samoa", flag = Res.drawable.samoa),
    XAF(country = "Central African Republic", flag = Res.drawable.central_african_republic),
    YER(country = "Yemen", flag = Res.drawable.yemen),
    ZAR(country = "South Africa", flag = Res.drawable.south_africa),
    ZMW(country = "Zambia", flag = Res.drawable.zambia),
    ZWL(country = "Zimbabwe", flag = Res.drawable.zimbabwe)
}