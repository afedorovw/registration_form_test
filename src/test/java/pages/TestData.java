package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-US"));
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-US"), new RandomService());

    protected final String FIRST_NAME = faker.name().firstName();
    protected final String LAST_NAME = faker.name().lastName();
    protected final String EMAIL = faker.internet().emailAddress();

    protected final String NUMBER = faker.phoneNumber().subscriberNumber(10);
    protected final String GENDER = faker.demographic().sex();
    protected final String DATE_OF_BIRTH = fakeValuesService.regexify("(0[1-9]|1[0-2])\\.([0-2][1-9])\\.19([0-9]{2})");
    protected final String STREET_NAME = faker.address().streetName();
    protected final String BUILDING_NUMBER = faker.address().buildingNumber();
    protected final String CITY = faker.address().city();
    protected final String ADDRESS = String.format("%s %s %s", STREET_NAME, BUILDING_NUMBER, CITY);

    LocalDate date = LocalDate.parse(DATE_OF_BIRTH, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
    protected String updateDateOfBirth = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));
}
