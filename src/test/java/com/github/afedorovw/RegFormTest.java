package com.github.afedorovw;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static com.github.afedorovw.utils.RandomUtils.getRandomEmail;
import static com.github.afedorovw.utils.RandomUtils.getRandomPhone;

public class RegFormTest extends TestBase {

    String userEmail = getRandomEmail();
    String userPhone = getRandomPhone();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
//    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.lebowski().quote() + " " +
            faker.address();

    private static final String website = "https://demoqa.com/automation-practice-form";

    @Test
    @Description("Practice Form test")
    @DisplayName("Проверка заполнения общей формы")
    void practiceFormTest() {
        Allure.label("owner", "afedorovw");
        Allure.link ("DemoQA", "https://demoqa.com/");
        Allure.parameter("demoqa", "dautomation-practice-form");

        step ("Открываем главную страницу" + website, () -> {
        open(website);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });

        step ("Заполняем форму", () -> {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(userPhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/pict.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("pict.jpg");
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").shouldHave(text("Submit"));
        $("#submit").click();
        });

        step ("Проверка отправки формы", () -> {
            Allure.addAttachment("PageSource", "text/html", WebDriverRunner.source(), "html");
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));
        });
    }

    @Test
    @Description("Annotated Steps test")
    @DisplayName("Проверка заполнения формы")
    public void annotatedStepsTest() {
        Allure.parameter("demoqa", "text-box");

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.formFilling();
        steps.formCheck();
    }
}
