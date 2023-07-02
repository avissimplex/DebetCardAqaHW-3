package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebCardNegativeTest {
    @Test
    void ShouldTestLatinName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Kouzma Petrov-Vodkin");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void ShouldTestOnlyFirstName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void ShouldTestOnlyLastName() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Иванов");
        form.$("[name=phone]").setValue("+77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void ShouldTestFalseNumberWithoutPlus() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("77777777777");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void ShouldTestFalseNumberWithPlus() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("+1");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void ShouldTestNoAgreement() {
        open ("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[name=name]").setValue("Кузьма Петров-Водкин");
        form.$("[name=phone]").setValue("77777777777");
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}