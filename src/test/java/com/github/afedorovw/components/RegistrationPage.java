package com.github.afedorovw.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    CalendarComponent calendarComponent = new CalendarComponent();

    public void typeFirstName() {
        firstNameInput.setValue("Igor");
    }

    public void typeLastName() {
        lastNameInput.setValue("Nem");
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);

        return this;
    }
}
