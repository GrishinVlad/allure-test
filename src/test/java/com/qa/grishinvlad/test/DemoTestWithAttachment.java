package com.qa.grishinvlad.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;


public class DemoTestWithAttachment {

    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void testAttachment(){
        driver.get("https://google.com");
        attachScreenshot();
        attachTitle();
    }

    @Attachment
    public byte[] attachScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Тайтл страницы", type = "text/plain", fileExtension = ".txt")
    public byte[] attachTitle(){
        return driver.getTitle().getBytes(Charset.forName("UTF-8"));
    }

    @Test
    public void testAttachment2(){
        driver.get("https://yandex.ru");
        Allure.addAttachment("Screenshot",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        Allure.addAttachment("Title page","text/plain",driver.getTitle(),".txt");
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
