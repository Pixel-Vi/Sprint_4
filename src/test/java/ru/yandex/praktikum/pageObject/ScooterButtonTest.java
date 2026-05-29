package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ScooterButtonTest {
    WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(site);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testScooterButtonFromAboutRenterReturnsToHome() {
        HomePage homePage = new HomePage(driver);
        AboutRenter aboutRenter = new AboutRenter(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .inputName("Имя")
                .inputSurname("Фамилия")
                .inputAddress("Адрес")
                .changeStateMetro(77)
                .inputTelephone("+79999999999")
                .clickNextButton();

        // Клик по кнопке «Скутер» через HomePage
        homePage.clickScooterButton();

        // Проверка: заголовок главной страницы виден
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getHomeHeader()));

        assertTrue(driver.getCurrentUrl().contains("qa-scooter"));
    }

    // Аналогично исправьте остальные тесты
}
