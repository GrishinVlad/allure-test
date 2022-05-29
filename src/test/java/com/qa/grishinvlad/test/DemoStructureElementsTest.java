package com.qa.grishinvlad.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoStructureElementsTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Epic("Отображение страниц yandex")
    @Feature("Отображение главной страницы ya.ru")
    @Story("Я как пользователь перехожу на страницу ya.ru")
    @Test
    public void demoStructureElementsTest1(){
        driver.get("https://ya.ru");
    }

    @Epic("Отображение страниц google")
    @Feature("Отображение главной страницы google.com")
    @Story("Я как пользователь перехожу на страницу google.com")
    @Test
    public void demoStructureElementsTest2(){
        driver.get("https://google.com");
    }

    @Epics({@Epic("Отображение страниц google"),@Epic("Отображение страниц yandex")})
    @Features({@Feature("Отображение главной страницы google.com"),@Feature("Отображение главной страницы yandex.ru")})
    @Stories({@Story("Я как пользователь перехожу на страницу google.com"),@Story("Я как пользователь перехожу на страницу yandex.ru")})
    @Test
    public void demoStructureElementsUnionTest(){
        driver.get("https://yandex.ru");
        driver.get("https://google.com");
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
