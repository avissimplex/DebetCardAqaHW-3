package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebCardNegativeTest {
    @Test
    void shouldTestInvalideName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Kouzma Petrov-Vodkin");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[class='input__control']").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void shouldTestOnlyEmptyName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[class='input__top']").shouldHave(exactText("Поле обязательно для заполнения"));

    }
/*
    @Test
    void shouldTestOnlyLastName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Иванов");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldTestFalseNumberWithoutPlus() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldTestFalseNumberWithPlus() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("+1");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldTestNoAgreement() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("77777777777");
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }*/
}