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

public class TransitionIntoPersonalAccTest {

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

        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);

        //Нажать на кнопку Войти
        mainPage.clickButtonEntrance();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickButtonLogin();

    }

    @Test
    @DisplayName("Transition into Personal account")
    public void transitionIntoPersonalAccTest(){
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);
        mainPage.clickButtonPersonalAccount();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);

        personalAccountPage.inputNameIsVisible();
        personalAccountPage.inputLoginIsVisible();
        personalAccountPage.inputPasswordIsVisible();
        personalAccountPage.profileSectionIsVisible();
        personalAccountPage.historyOfOrdersSectionIsVisible();
        personalAccountPage.exitSectionSectionIsVisible();
    }
}
