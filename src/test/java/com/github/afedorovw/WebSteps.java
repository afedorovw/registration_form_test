package com.github.afedorovw;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    public static String name = "SomeName",
                        email = "some@email.com",
                        curAddr = "Some address",
                        anotAddr = "Another address";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://demoqa.com/text-box");
    }

    @Step("Заполняем форму")
    public void formFilling() {
        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(curAddr);
        $("#permanentAddress").setValue(anotAddr);
        $("#submit").scrollTo().click();
    }

    @Step("Проверяем форму")
    public void formCheck() {
        attachPageSource();
        $("#output").shouldBe(visible);
        $("#name").shouldHave(text(name));
        $("#email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(curAddr));
        $("#output").$("#permanentAddress").shouldHave(text(anotAddr));
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
