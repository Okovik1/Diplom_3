package stellaburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonEntrance;

    //Нажать на кнопку "Войти в аккаунт"
    public void clickButtonEntrance(){
        buttonEntrance.click();
    }

    // "Личный кабинет" хедер
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;

    //Нажать на кнопку "Войти в  Личный кабинет"
    public void clickButtonPersonalAccount(){
        buttonPersonalAccount.click();
    }

    //Кнопка оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement buttonMakeAnOrder;

    //Кнопка оформить заказ отображается
    public void buttonMakeAnOrderIsVisible(){
        buttonMakeAnOrder.isDisplayed();
    }

    //"Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement createBurger;

    //Заголовок Соберите бургер отображается
    public void createBurgerIsVisible(){
        buttonMakeAnOrder.isDisplayed();
    }

    //"Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsSection;

    //Булки
    public void bunsSectionIsVisible(){
        bunsSection.isDisplayed();
    }

    //Соусы
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement sauceSection;

    //Булки
    public void sauceSectionIsVisible(){
        sauceSection.isDisplayed();
    }

    //Верхний раздел Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceSectionHeader;

    //Булки
    public void clickSauceSection(){
        sauceSectionHeader.click();
    }

    //Верхний раздел Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsSectionHeader;

    //Булки
    public void clickBunsSectionHeader(){
        bunsSectionHeader.click();
    }

    //Верхний раздел Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsSectionHeader;

    //Начинки нажать
    public void clickFillingsSectionHeader(){
        fillingsSectionHeader.click();
    }

    // Начинки
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsSection;

    //Начинки отображаются
    public void fillingsSectionIsVisible(){
        fillingsSection.isDisplayed();
    }

    //Значок StellarsBurgers
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarsBurgers;

    //Нажать на StellarsBurgers
    public void clickStellarsBurgers(){
        stellarsBurgers.isDisplayed();
    }











}
