# cucumberProject
API and UI automation project with Cucumber fw

Proje gereksinimleri

- JDK, -> https://www.oracle.com/java/technologies/downloads/
- Intellij idea veya Eclipse IDE, -> https://www.jetbrains.com/idea/download/
- Google Chrome, https://www.google.com/intl/tr_tr/chrome/
- Tarayıcınıza ve işletim sisteminize uygun chrome driver,(ilgili adresten gerekli driver’ı indirip proje içerisindeki driver dizinindeki chromedriver ile değiştirmeniz yeterlidir.) -> https://chromedriver.chromium.org/downloads
- IDE üzerinde "Cucumber for Java" ve "Gherkin" pluginleri indirilmelidir.

Çalıştırma

-Raporlama vb. ek özellikler için junit fw kullanıldı. Bu sebeple otomasyon setini koşmak için src-test-java altında bulunan testRunner class’ına sağ tıklayıp run testRunner seçilmelidir. Uygulama tüm stepleri koştuktan sonra online test raporunu konsol çıktısı olarak üretecektir. Aynı zamanda proje dizini altındaki target-cucumber-reports altına da en son test raporunu hem html hem json formatında ekleyecektir.(Not: Intellij proje ilk açıldığında projeye güven ayarını seçmeden kodu derlemiyor. Bir kereye mahsus ilk açılışta projeye güven seçeneği işaretlenmelidir.)
