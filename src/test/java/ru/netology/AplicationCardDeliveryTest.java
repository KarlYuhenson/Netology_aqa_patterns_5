package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class AplicationCardDeliveryTest {
    SelenideElement form = $("form");
    SelenideElement cityForm = form.$("[data-test-id=city] input");
    SelenideElement cityClick = $(".menu");
    SelenideElement dateForm = form.$("[data-test-id=date] input");
    SelenideElement nameForm = form.$("[data-test-id=name] input");
    SelenideElement phoneForm = form.$("[data-test-id=phone] input");
    SelenideElement agreementForm = form.$("[data-test-id=agreement]");
    SelenideElement button = $$("button").find(exactText("Запланировать"));
    SelenideElement notificationSuccess = $("[data-test-id='success-notification']");
    SelenideElement replanNotification = $("[data-test-id= 'replan-notification']");
    SelenideElement replanButton = $(byText("Перепланировать"));


    @BeforeEach
    void openHost() {
        open("http://localhost:9999");
    }


    @Test
    void shouldChangeDeliveryDate() {
        String randomCity = CitiesGenerator.getRandomCities();
        String randomNames = NamesGenerator.getRandomNames();

        cityForm.setValue(randomCity);
        cityClick.waitUntil(exist, 5000).click();
        dateForm.doubleClick().sendKeys(Keys.BACK_SPACE);
        dateForm.setValue(DataGenerator.getFutureDate(3));
        nameForm.setValue(randomNames);
        phoneForm.setValue("89261111111");
        agreementForm.click();
        button.click();
        notificationSuccess.waitUntil(visible, 15000);
        dateForm.doubleClick().sendKeys(Keys.BACK_SPACE);
        dateForm.setValue(DataGenerator.getFutureDate(5));
        button.click();
        replanNotification.waitUntil(visible, 15000);
        replanButton.click();
        replanNotification.waitUntil(exist, 15000);
    }
}