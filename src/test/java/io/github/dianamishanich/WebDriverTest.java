package io.github.dianamishanich;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class WebDriverTest {

    private WebDriver driver;
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {

        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @BeforeEach
    public void initDriver(){
        driver = new WebDriverProvider().get();
    }

    @Test
    public void webDriverTest() {
        System.out.println(config.remote());
        System.out.println(config.remoteURL());
        System.out.println(config.browserName());
        System.out.println(config.browserVersion());

        driver.get(config.baseUrl());

    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}
