package transitions;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import stellaburgerspageobject.LoginPage;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.PersonalAccountPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ExitFromPersonalAccTest {

    String userName;
    String email;
    String password;

    @Before
    public void setUp() {
        RegisterPage registerPage =
                open("https://stellarburgers.nomoreparties.site/register",
                        RegisterPage.class);

        userName = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);

        //Зарегистрировать пользователя
        registerPage.setName(userName);
        registerPage.setEmail(email);
        registerPage.setPassword(password);

        //Нажать кнопку Зарегистрироваться
        registerPage.clickButtonRegister();

    }

    @Test
    @DisplayName("Exit from personal account")
    public void exitFromPersonalAccTest() {

        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);

        //Нажать на кнопку Войти
        mainPage.clickButtonEntrance();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalAccount();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);

        personalAccountPage.clickExitSection();

        LoginPage loginPage1 = page(LoginPage.class);
        loginPage1.isEntranceTextDisplayed();
    }
}