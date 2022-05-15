package login;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import stellaburgerspageobject.LoginPage;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.RecoveryPasswordPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginFromPasswordRecoveryPageTest {

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
    @DisplayName("User login from password recovery page")
    public void loginFromPasswordRecoveryPageTest() {

        //На странице логина нажать на ссылку на Восстановление пароля
        LoginPage loginPage =
                open("https://stellarburgers.nomoreparties.site/login",
                        LoginPage.class);

        loginPage.clickRecoveryPasswordLink();

        // На странице восстановления пароля нажимаем Войти
        RecoveryPasswordPage recoveryPasswordPage = page(RecoveryPasswordPage.class);
        recoveryPasswordPage.clickEntranceLink();

        // Осуществляем вход на сайт
        loginPage.setEmailLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickButtonLogin();

        //Переход на главную страницу
        MainPage mainPage1 =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);

        // На месте кнопки Войти появилась кнопка Оформит заказ
        mainPage1.buttonMakeAnOrderIsVisible();

    }


}
