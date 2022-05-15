package stellaburgerspageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    //Инпут для написания Имени
    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div/div/input")
    private SelenideElement fillName;

    public void setName(String name1) {
        fillName.scrollIntoView(true);
        fillName.setValue(name1);
    }

    //Инпут для написания email
    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div/div/input")
    private SelenideElement fillEmail;

    public void setEmail(String email) {
        fillEmail.scrollIntoView(true);
        fillEmail.setValue(email);
    }

    //Инпут для написания пароля
    @FindBy(how = How.XPATH, using = ".//fieldset[3]/div/div/input")
    private SelenideElement fillPassword;

    public void setPassword(String password) {
        fillPassword.setValue(password);
    }

    //Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonRegister;

    public void clickButtonRegister(){
        buttonRegister.click();
    }

    //Ошибка некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[text()= 'Некорректный пароль']")
    private SelenideElement errorText;

    // Проверяем наличие ошибки "Некорректный пароль"
    public void isErrorTextDisplayed() {
        errorText.shouldHave(Condition.text("Некорректный пароль"));
    }

    //Уже зарегистрированы? Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    //Нажать на ссылку войти
    public void clickEnterLink(){
        enterLink.click();
    }

}
