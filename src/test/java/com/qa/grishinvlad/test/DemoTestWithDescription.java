package com.qa.grishinvlad.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

public class DemoTestWithDescription {

    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    @Description("Демонстрация использования аннотации Description")
    public void testAttachment(){
        driver.get("https://google.com");
    }



    /**
     * demo using tag Description with javadoc(works only on testng)
     */

    @Test
    @Description(useJavaDoc = true)
    public void testDescriptionJavaDoc(){
        driver.get("https://ya.ru");
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
