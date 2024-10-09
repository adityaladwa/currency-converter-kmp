import SwiftUI
import CurrencyApp

@main
struct iOSApp: App {
    
    init() {
        CurrencyApp.KoinModuleKt.initializeKoin()
    }
  
    var body: some Scene {
        WindowGroup {
            ContentView().ignoresSafeArea()
        }
    }
}
