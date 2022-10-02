package Test_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.a101.com.tr/");

        WebElement cookie = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookie.click();


        WebElement gymBtn = driver.findElement(By.xpath("//a [@href='/giyim-aksesuar/']"));
        Actions action = new Actions(driver);
        action.moveToElement(gymBtn).perform();

        WebElement corapBtn = driver.findElement(By.xpath("//a [@href='/giyim-aksesuar/dizalti-corap/']"));
        corapBtn.click();


        driver.findElement(By.xpath("//h3[@class='name']")).click();

        String actualColour = driver.findElement(By.xpath("//span[text()='SİYAH']")).getText();
        String expectedColour = "SİYAH";

        Assert.assertTrue(actualColour.contains(expectedColour));


        driver.findElement(By.xpath("//button[@data-pk='18864']")).click();


        WebElement sepetGor = driver.findElement(By.linkText("Sepeti Görüntüle"));
        sepetGor.click();

        WebElement sepetOnayla = driver.findElement(By.partialLinkText("Sepeti Onayla"));
        sepetOnayla.click();

        WebElement uyeOlmdnDvm = driver.findElement(By.partialLinkText("ÜYE OLMADAN DEVAM ET"));
        uyeOlmdnDvm.click();

        WebElement email = driver.findElement(By.name("user_email"));
        email.sendKeys("abcdefgh@gmail.com");

        driver.findElement(By.xpath("//button[contains(text( ),' DEVAM ET')]")).click();

        driver.findElement(By.linkText("Yeni adres oluştur")).click();


        Actions actions = new Actions(driver);
        WebElement adres1 = driver.findElement(By.xpath("//input[@name='title']"));
        actions.click(adres1).sendKeys("Ev").sendKeys(Keys.TAB).sendKeys("Hasan").sendKeys(Keys.TAB).sendKeys("Kayaclı")
                .sendKeys(Keys.TAB).sendKeys("5425509999").build().perform();

        Select drpCity = new Select(driver.findElement(By.xpath("//select[@name='city']")));
        drpCity.selectByVisibleText("İSTANBUL");


        Select drpTown = new Select(driver.findElement(By.xpath("//select[@name='township']")));
        drpTown.selectByVisibleText("BEYLİKDÜZÜ");


        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement drpDstrict2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='district']")));
        drpDstrict2.click();

        WebElement value = driver.findElement(By.xpath("//option[@value='35601']"));
        value.click();

        WebElement adres2 = driver.findElement(By.xpath("//textarea[@name='line']"));
        actions.click(adres2).sendKeys("Avrupa Cd. No:901 Beykent").sendKeys(Keys.TAB).click()
                .build().perform();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement save=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button'] ")));
        save.click();


        WebElement save2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-index='1']")));
        save2.click();

        WebElement cardName = driver.findElement(By.xpath("(//input[@name='name'])[2]"));
        cardName.sendKeys("Yener Kıpırdı");

        WebElement cardNumber = driver.findElement(By.xpath("//input[@class='js-masterpassbin-payment-card']"));
        cardNumber.sendKeys("5328135057729665");

        WebElement cardMonth=driver.findElement(By.xpath("(//select[@name='card_month'])[2]"));
        Select cardMonthS = new Select(cardMonth);
        cardMonthS.selectByVisibleText("9");

        Select cardYear = new Select(driver.findElement(By.xpath("(//select[@name='card_year'])[2]")));
        cardYear.selectByVisibleText("2032");

        WebElement cardCvv = driver.findElement(By.xpath("(//input[@name='card_cvv'])[2]"));
        cardCvv.sendKeys("946");

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).build().perform();


        WebElement orderComplete = driver.findElement(By.xpath("(//*[text()='Siparişi Tamamla'])[2]"));
        orderComplete.click();

        Assert.assertEquals(driver.findElement(By.id("approve-header")).getText(), "Doğrulama kodunu giriniz");
        System.out.println("TEST PASSED...");

        driver.close();
    }
}
