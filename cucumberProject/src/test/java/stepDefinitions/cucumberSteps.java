package stepDefinitions;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;
import io.cucumber.plugin.event.Node;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import javax.xml.bind.Element;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static sun.nio.cs.Surrogate.is;

public class cucumberSteps {

    public WebDriver driver;

    @Given("mobile - websitesi açılır")
    public void mobile_websitesi_açılır() {

        System.setProperty("webdriver.chrome.driver","drivers//chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://pro.btcturk.com/basit/al-sat/BTC_TRY");
        driver.manage().window().maximize();
    }

    @When("mobile - 24s en yuksek alanidaki değerin 24s en dusuk alanindaki degerden buyuk oldugu kontrol edilir")
    public void mobile_24s_en_yuksek_alanidaki_değerin_24s_en_dusuk_alanindaki_degerden_buyuk_oldugu_kontrol_edilir() throws Exception {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String enYuksek = driver.findElement(By.cssSelector("#ex-advanced-ticker-high")).getText();
        String enDusuk = driver.findElement(By.cssSelector("#ex-advanced-ticker-low")).getText();

        Double enYuksekDeger = Double.parseDouble(enYuksek.replaceAll(",", ""));
        Double enDusukDeger = Double.parseDouble(enDusuk.replaceAll(",", ""));

        if (enYuksekDeger>enDusukDeger){

            System.out.println("Gösterim doğrudur.");

        }

        else {

            System.out.println("Gösterim yanlıştır.");
            throw new Exception();


        }


    }


    @When("mobile - USDT  TRY secimi yapilir")
    public void mobile_usdt_try_secimi_yapilir() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement btnDetay = driver.findElement(By.xpath("//*[@id='main']/exchange-basic/main/div/div/div[1]/ticker-bar/ul/li[1]/selected-pair/button"));
        btnDetay.click();
        WebElement input = driver.findElement(By.xpath("//*[@id='main']/exchange-basic/main/div/div/div[1]/ticker-bar/ul/li[1]/div/pair-list/div/div[1]/div/input"));
        input.click();
        input.sendKeys("USDTTRY");
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@id='main']/exchange-basic/main/div/div/div[1]/ticker-bar/ul/li[1]/div/pair-list/div/div[3]/perfect-scrollbar"));
        aramaSonucu.click();
    }

    @Given("api - {string} adresine {string} pathi ile GET isteği atılır ve servisten response code {string} döndüğü kontrol edilir")
    public void api_https_reqres_in_api_users_adresine_ve_parametreleri_gönderilerek_isteği_atılır(String address, String path, String code) {

        RestAssured.baseURI = address;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .extract().response();

        Assertions.assertEquals(Integer.parseInt(code), response.statusCode());
    }

    @Given("api - {string} adresine {string} pathi {string} ve {string} parametreleri gönderilerek POST isteği atılır ve servisten response code {string} döndüğü kontrol edilir")
    public void api_adresine_ve_parametreleri_gönderilerek_post_isteği_atılır_ve_servisten_response_code_döndüğü_kontrol_edilir(String address, String path, String name, String job, String code) {

        String requestBody = "{\"name\" : \""+name+"\",\n" +
                "\"job\": \""+job+"\"\n" +
                "}" ;

        RestAssured.baseURI = address;
        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post(path)
                .then()
                .extract().response();

        Assertions.assertEquals(Integer.parseInt(code), response.statusCode());

    }

    @Given("mobile - Browser kapatılır")
    public void mobile_browser_kapatılır() {

        driver.close();

    }

}
