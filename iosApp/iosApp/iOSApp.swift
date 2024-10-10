import SwiftUI
import CurrencyApp

@main
struct iOSApp: App {
    
    init() {
        Initializer().doInitAll()
    }
  
    var body: some Scene {
        WindowGroup {
            ContentView().ignoresSafeArea()
        }
    }
}
