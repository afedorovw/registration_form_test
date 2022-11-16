package pages.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
public class CalendarComponent {

    public void setDate(LocalDate dateOfBirth) {
        String month = dateOfBirth.format(DateTimeFormatter.ofPattern("MMMM", new Locale("en")));
        String day = dateOfBirth.format(DateTimeFormatter.ofPattern("dd", new Locale("en")));

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(dateOfBirth.getYear()));
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
