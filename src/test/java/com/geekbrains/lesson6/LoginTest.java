package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get("https://crm.geekbrains.space/");
    }

    @Test
    void loginTest() {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Расходы");
        new ExpensesSubMenu(webDriver)
                .expensesButtonClick()
                .createExpenseButtonClick();

        new CreateExpensePage(webDriver)
                .fillExpenseAppointment("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectCurrency("Доллар США")
                .fillSumPlanInput("100")
                .selectPlannedDate("15")
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Заявка на расход сохранена']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
