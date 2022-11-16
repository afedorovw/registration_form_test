package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.FormPage;
import pages.TestData;

public class BaseTest {

    FormPage formPage = new FormPage();
    TestData testData = new TestData();

    @BeforeAll
    static public void config() {
        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.browserSize = "1920x1080";
//        Configuration.browserPosition = "0x0";
    }
}
