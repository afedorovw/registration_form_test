package tests;

import org.junit.jupiter.api.Test;

public class FormTest extends BaseTest{

    @Test
    public void onlyRequiredFieldsTest() {
        formPage.openPage()
                .fillForm(testData)
                .checkForm(testData);
    }
}
