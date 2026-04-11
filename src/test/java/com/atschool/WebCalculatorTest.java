package com.atschool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebCalculatorTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeEach
    void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
    }

    @Test
    void testOnlineCalculator() throws Exception {
        driver.get("https://www.calculator.net/");
        Thread.sleep(3000);
        System.out.println("✅ Калькулятор загружен");

        // Нажимаем кнопки с паузами
        System.out.println("🔘 Нажимаем 5");
        js.executeScript("r(5)");
        Thread.sleep(1000);

        System.out.println("🔘 Нажимаем +");
        js.executeScript("r('+')");
        Thread.sleep(1000);

        System.out.println("🔘 Нажимаем 3");
        js.executeScript("r(3)");
        Thread.sleep(1000);

        System.out.println("🔘 Нажимаем =");
        js.executeScript("r('=')");
        Thread.sleep(1500);

        // Получаем результат
        String result = (String) js.executeScript(
                "var el = document.getElementById('sciOutPut');" +
                        "return el ? (el.value || el.innerText || el.innerHTML) : '0';"
        );
        System.out.println("📊 Результат: " + result);

        // Проверяем
        assertTrue(result.contains("8"), "5 + 3 = 8, а получилось: " + result);
        System.out.println("✅ ТЕСТ ПРОЙДЕН! 5 + 3 = " + result);

        Thread.sleep(2000);
    }

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();
        }
    }
}