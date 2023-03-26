package ru.netology.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardApplicationTest {
    private WebDriver driver;


    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void shouldSend() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendDoubleName() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Игнатьева Анна-Мария");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendDoubleSurname() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Игнатьева-Мироненко Анна");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendDoubleAll() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Игнатьева-Мироненко Анна-Мария");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

//    @Test
//    void shouldSendYo() {
//        driver.get("http://localhost:9999");
//
//        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Игнатьев Пётр");
//        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
//        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
//        driver.findElement(By.cssSelector("[type=button]")).click();
//
//        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();
//
//        assertEquals(expected, actual);
//    }

    @Test
    void shouldSendWithUsingSpace() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Мамаев Марат оглы");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendWithLowercaseName() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("свиридов николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendZeroNumber() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+00000000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSendLatinLetters() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Sviridov Nikolai");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSendEmptyName() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSendWithSpecialSymbols() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свир$дов Ник?лай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSendWithNumbersInName() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Св1рид0в Ник0лай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotSendEmptyPhone() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendIfPhoneNumberLess() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7969969969");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSendIfPhoneNumberMore() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+796996996969");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText().trim();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSendWithoutAgreement() {
        driver.get("http://localhost:9999/");

        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Свиридов Николай");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79699699696");
        driver.findElement(By.cssSelector("[type=button]")).click();

        String expected = "Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй";
        String actual = driver.findElement(By.cssSelector("[data-test-id='agreement'].input_invalid.checkbox")).getText().trim();

        assertEquals(expected, actual);
    }

}
