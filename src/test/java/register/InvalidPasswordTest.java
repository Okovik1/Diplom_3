package register;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class InvalidPasswordTest {

    @Test
    @DisplayName("Validation error via invalid length of password")
    public void invalidPasswordTest() {
        //открывается страница и создаётся экземпляр класса страницы
        RegisterPage registerPage =
                open(RegisterPage.URL,
                        RegisterPage.class);

        //Заполнить все поля регистрационной формы
        registerPage.setName(RandomStringUtils.randomAlphabetic(10));
        registerPage.setEmail(RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@yandex.ru");
        registerPage.setPassword(RandomStringUtils.randomAlphabetic(5));

        //Нажать кнопку Зарегистрироваться
        registerPage.clickButtonRegister();

        //Проверить появление ошибки
        Assert.assertTrue("Не отобразилась ошибка Некорректный пароль", registerPage.isErrorTextDisplayed());

    }
}
