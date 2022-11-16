package pages.components;

import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;

public class ResultForm {
    public void assertFormParam(String key, String value) {
        $(".modal-body").find(new ByText(key)).parent().lastChild()
                .shouldHave(new Text(value));
    }
}
