package stellaburgerspageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Заглавие инпутов - "Вход"
    @FindBy(how = How.XPATH, using = ".//div[@class= 'Auth_login__3hAey']/h2[text()='Вход']")
    private SelenideElement entranceText;

    // Проверяем наличие Заглавия инпутов - "Вход"
    public boolean isEntranceTextDisplayed() {
        entranceText.shouldBe(Condition.visible, Duration.ofSeconds(10));
        entranceText.shouldHave(Condition.text("Вход"));
        return entranceText.isDisplayed();
    }

    //Инпут Email
    @FindBy(how = How.XPATH, using = ".//fieldset[1][@class='Auth_fieldset__1QzWN mb-6']/div/div/input")
    private SelenideElement fillEmailLogin;

    public void setEmailLogin(String email2) {
        fillEmailLogin.setValue(email2);
    }

    //Инпут Пароль
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input")
    private SelenideElement fillPasswordLogin;

    public void setPasswordLogin(String password2) {
        fillPasswordLogin.setValue(password2);
    }

    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonLogin;

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    //Вы — новый пользователь? Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    public void clickRegisterLink() {
        registerLink.click();
    }

    //Забыли пароль? Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordLink;

    public void clickRecoveryPasswordLink() {
        recoveryPasswordLink.click();
    }

}
