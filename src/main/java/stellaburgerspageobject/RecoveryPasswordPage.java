package stellaburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoveryPasswordPage {

    //Вспомнили пароль? Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entranceLink;

    public void clickEntranceLink() {
        entranceLink.click();
    }


}
