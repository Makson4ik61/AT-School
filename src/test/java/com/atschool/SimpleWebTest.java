package com.atschool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleWebTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    // Твой существующий тест для Google
    @Test
    void testGoogleSearch() throws Exception {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        Thread.sleep(2500);
        driver.findElement(By.name("q")).submit();
        Thread.sleep(3500);
        assertTrue(driver.getTitle().contains("Selenium"));
        System.out.println("Тест пройден! Заголовок: " + driver.getTitle());
    }

    // ⭐ Твой НОВЫЙ тест для GitHub (добавь его сюда)
    @Test
    void testGitHub() throws Exception {
        // 1. Открываем твой профиль на GitHub
        driver.get("https://github.com/Makson4ik61");
        Thread.sleep(5000); // Ждём полной загрузки страницы

        // 2. Получаем заголовок страницы
        String title = driver.getTitle();

        // 3. Выводим заголовок в консоль
        System.out.println("Твой GitHub профиль: " + title);

        // 4. Проверяем, что заголовок содержит твой username
        assertTrue(title.contains("Makson4ik61"),
                "Заголовок страницы не содержит ожидаемое имя! Заголовок: " + title);

        // (Дополнительно) Можешь также проверить, что на странице есть твой username в тексте
        boolean hasUsername = driver.getPageSource().contains("Makson4ik61");
        assertTrue(hasUsername, "На странице не найден текст Makson4ik61");
    }

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}