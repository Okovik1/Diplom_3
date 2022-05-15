package login;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import stellaburgerspageobject.LoginPage;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginFromRegisterFormTest {
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
    @DisplayName("User login from register form")
    public void loginFromRegisterFormTest() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickEnterLink();

        LoginPage loginPage2 = page(LoginPage.class);
        //Заполнение данных по пользователю
        loginPage2.setEmailLogin(email);
        loginPage2.setPasswordLogin(password);
        loginPage2.clickButtonLogin();

        //Переход на главную страницу
        MainPage mainPage1 =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);

        // На месте кнопки Войти появилась кнопка Оформит заказ
        mainPage1.buttonMakeAnOrderIsVisible();
    }
}
