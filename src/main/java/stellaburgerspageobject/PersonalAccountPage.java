package stellaburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    //Поле Имя
    @FindBy(how = How.XPATH, using = ".//input[1][@name='Name']")
    private SelenideElement inputName;

    public void inputNameIsVisible(){
        inputName.isDisplayed();
    }

    //Поле логин
    @FindBy(how = How.XPATH, using = ".//input[2][@name='name']")
    private SelenideElement inputLogin;

    public void inputLoginIsVisible(){
        inputLogin.isDisplayed();
    }

    //Поле логин
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement inputPassword;

    public void inputPasswordIsVisible(){
        inputPassword.isDisplayed();
    }

    //Профиль
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profileSection;

    public void profileSectionIsVisible(){
        profileSection.isDisplayed();
    }

    //История заказов
    @FindBy(how = How.XPATH, using = ".//a[text()='История заказов']")
    private SelenideElement historyOfOrdersSection;

    public void historyOfOrdersSectionIsVisible(){
        historyOfOrdersSection.isDisplayed();
    }

    //Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitSection;

    public void exitSectionSectionIsVisible(){
        exitSection.isDisplayed();
    }

    //Нажать на выход
    public void clickExitSection(){
        exitSection.click();
    }

    //Значок StellarsBurgers
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarsBurgers;

    //Нажать на StellarsBurgers
    public void clickStellarsBurgers(){
        stellarsBurgers.click();
    }

    //Значок Конструктор
    @FindBy(how = How.XPATH, using = ".//a[1][@class='AppHeader_header__link__3D_hX']")
    private SelenideElement constructor;

    //Нажать на constructor
    public void clickConstructor(){
        constructor.click();
    }


}
