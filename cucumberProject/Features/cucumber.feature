Feature: BTC TURK UI VE API TEST


  Scenario: 1.0 - 24s en yuksek ve 24s en dusuk alani kontrol
    * mobile - websitesi açılır
    * mobile - 24s en yuksek alanidaki değerin 24s en dusuk alanindaki degerden buyuk oldugu kontrol edilir
    * mobile - Browser kapatılır

  Scenario: 1.1 - 24s en yuksek ve 24s en dusuk alani kontrol
    * mobile - websitesi açılır
    * mobile - USDT  TRY secimi yapilir
    * mobile - 24s en yuksek alanidaki değerin 24s en dusuk alanindaki degerden buyuk oldugu kontrol edilir
    * mobile - Browser kapatılır

  Scenario: 1.2 - Rest api ile kullanıcı oluşturma
    * api - "https://reqres.in" adresine "/api/users" pathi "ali" ve "testçi" parametreleri gönderilerek POST isteği atılır ve servisten response code "201" döndüğü kontrol edilir

  Scenario: 1.3 - Rest api üzerinden response code kontrolü
    * api - "https://reqres.in" adresine "/api/1" pathi ile GET isteği atılır ve servisten response code "200" döndüğü kontrol edilir

  Scenario: 1.4 - Rest api üzerinden response code kontrolü
    * api - "https://reqres.in" adresine "/api/users?page=1" pathi ile GET isteği atılır ve servisten response code "200" döndüğü kontrol edilir



