package register;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import stellaburgerspageobject.LoginPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PositiveRegisterTest {

    @Test
    @DisplayName("User successfully login")
    public void positiveRegisterTest() {
        //открывается страница и создаётся экземпляр класса страницы
        RegisterPage registerPage =
                open(RegisterPage.URL,
                        RegisterPage.class);

        //Заполнить все поля регистрационной формы
        registerPage.setName(RandomStringUtils.randomAlphabetic(10));
        registerPage.setEmail(RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@yandex.ru");
        registerPage.setPassword(RandomStringUtils.randomAlphabetic(10));

        //Нажать кнопку Зарегистрироваться
        registerPage.clickButtonRegister();

        //Проверка перехода на страницу Входа
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Не отобразился заголовок Вход", loginPage.isEntranceTextDisplayed());
    }
}
