package com.github.afedorovw;

import com.codeborne.selenide.Configuration;
import com.github.afedorovw.components.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageobjectTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        registrationPage.typeFirstName();
        registrationPage.typeLastName();
        registrationPage.typeEmail("some@mail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        registrationPage.setBirthDate("30", "July", "2008");
        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/pict.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("pict.jpg");
        $("#currentAddress").val("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").shouldHave(text("Submit"));
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
