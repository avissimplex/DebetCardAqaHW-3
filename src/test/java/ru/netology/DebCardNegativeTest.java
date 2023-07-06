package ru.netology;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebCardNegativeTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void shouldTestInvalideName() {
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Kouzma Petrov-Vodkin");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void shouldTestEmptyName() {
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

 @Test
    void shouldTestOnlyFirstName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Иванов");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id='name'] .input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldTestInvalidPhone() {
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("666");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id='phone'] [class='input__sub']").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldTestNoPhone() {
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Мария Семенова");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id='phone'] [class='input__sub']").shouldHave(exactText("Поле обязательно для заполнения"));

    }


    @Test
    void shouldTestNoAgreement() {
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Иван Иванов");
        form.$("[name=phone]").setValue("+79093442632");
        form.$("[role=button]").click();
        $("[data-test-id='agreement']").shouldHave(attribute("class", "checkbox checkbox_size_m checkbox_theme_alfa-on-white input_invalid"));

    }
}