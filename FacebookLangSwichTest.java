package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 11.03.2016.
 */
public class FacebookLangSwichTest {


    WebDriver driver;


    By uaLink = By.xpath("//div[@data-referrer='page_footer']//a[@title='Ukrainian']");

    By uaTitle = By.xpath("//*[@class='clearfix']/div[2]/div[1]/div[1]");



    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        // Выставить ожидание элементов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Ожидание загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void switchRuToUa(){
        driver.get("https://ru-ru.facebook.com/");
        driver.findElement(uaLink).click();
        String regTitle = driver.findElement(uaTitle).getText();
        log(regTitle);
        Assert.assertEquals(regTitle,"ваваываыв");
    }

    @AfterTest
    public void thearDown(){
        driver.close();
        driver.quit();
    }






    public void log(String s){
        System.out.println(s);
    }





}
