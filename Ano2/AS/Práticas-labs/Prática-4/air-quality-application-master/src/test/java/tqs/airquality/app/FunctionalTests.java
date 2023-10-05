package tqs.airquality.app;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

@ExtendWith(SeleniumJupiter.class)
class FunctionalTests {

    WebDriver driver;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    FunctionalTests()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
    }

    @Test
    void checkCache() {
        driver.get("http://localhost:8080/cache");
        assertThat(driver.findElement(By.cssSelector(".page-title")).getText(), is("Cache Statistics"));
        {
            List<WebElement> elements = driver.findElements(By.xpath("//td"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.xpath("//tr[2]/td"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.xpath("//tr[3]/td"));
            assert(elements.size() > 0);
        }
    }

    @Test
    void searchInvalidAddressForecast() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("tqstqstqstqs");
        driver.findElement(By.id("scope")).click();
        {
            WebElement dropdown = driver.findElement(By.id("scope"));
            dropdown.findElement(By.xpath("//option[. = 'Forecast']")).click();
        }
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("span:nth-child(4)"));
            assert(elements.size() > 0);
        }
    }

    @Test
    void searchInvalidAddressHistorical() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("tqstqstqstqs");
        driver.findElement(By.id("scope")).click();
        driver.findElement(By.cssSelector("option:nth-child(3)")).click();
        driver.findElement(By.id("input-start")).click();
        driver.findElement(By.id("input-start")).sendKeys("01/05/2021");
        driver.findElement(By.id("input-end")).click();
        driver.findElement(By.id("input-end")).sendKeys("08/05/2021");
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("span:nth-child(4)"));
            assert(elements.size() > 0);
        }
    }

    @Test
    void searchInvalidAddressToday() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("tqstqstqstqstqs");
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("span:nth-child(4)"));
            assert(elements.size() > 0);
        }
    }

    @Test
    void searchValidAddressForecast() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Murtosa");
        driver.findElement(By.id("scope")).click();
        {
            WebElement dropdown = driver.findElement(By.id("scope"));
            dropdown.findElement(By.xpath("//option[. = 'Forecast']")).click();
        }
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("tr:nth-child(5) > td:nth-child(9)"));
            assert(elements.size() > 0);
        }
    }

    @Test
    void searchValidAddressHistorical() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Murtosa");
        driver.findElement(By.id("scope")).click();
        {
            WebElement dropdown = driver.findElement(By.id("scope"));
            dropdown.findElement(By.xpath("//option[. = 'Historical']")).click();
        }
        driver.findElement(By.cssSelector("option:nth-child(3)")).click();
        driver.findElement(By.id("input-start")).click();
        driver.findElement(By.id("input-start")).sendKeys("01/05/2021");
        driver.findElement(By.id("input-end")).click();
        driver.findElement(By.id("input-start")).click();
        driver.findElement(By.id("input-start")).click();
        driver.findElement(By.id("input-start")).sendKeys("01/05/2021");
        driver.findElement(By.id("input-end")).click();
        driver.findElement(By.id("input-end")).click();
        driver.findElement(By.id("input-end")).sendKeys("08/05/2021");
        driver.findElement(By.id("searchAddress")).click();
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("tr:nth-child(1) > td:nth-child(9)"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("tr:nth-child(8) > td:nth-child(9)"));
            assert(elements.size() > 0);
        }
    }


    @Test
    void searchValidAddressToday() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Murtosa");
        driver.findElement(By.cssSelector(".btn-submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".col-12 > .m-t-5"));
            assert(elements.size() > 0);
        }
        assertThat(driver.findElement(By.cssSelector(".col-12 > .m-t-5")).getText(), is(LocalDate.now().format(formatter)));
    }

}
