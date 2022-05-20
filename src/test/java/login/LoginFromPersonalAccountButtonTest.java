package login;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellaburgerspageobject.LoginPage;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginFromPersonalAccountButtonTest {

    String userName;
    String email;
    String password;

    @Before
    public void setUp() {
        RegisterPage registerPage =
                open(RegisterPage.URL,
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
    @DisplayName("User login from personal account button")
    public void loginFromPersonalAccountButtonTest() {
        MainPage mainPage =
                open(MainPage.URL,
                        MainPage.class);

        //Нажать на кнопку Войти
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickButtonLogin();

        //Переход на главную страницу
        MainPage mainPage1 =
                open(MainPage.URL,
                        MainPage.class);

        // На месте кнопки Войти появилась кнопка Оформить заказ
        Assert.assertTrue("Не отобразилась кнопка Оформить заказ", mainPage1.buttonMakeAnOrderIsVisible());
    }

}
