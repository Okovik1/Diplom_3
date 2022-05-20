package transitions;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class FromPersonalAccToMainPageViaStellarsurgersTest {

    @Test
    @DisplayName("Transition from Personal account to mai page via Stellar Burgers label")
    public void fromPersonalAccToMainPageViaStellarsurgersTest(){

        MainPage mainPage=
                open(MainPage.URL,
                        MainPage.class);

        mainPage.clickButtonPersonalAccount();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickStellarsBurgers();

        MainPage mainPage1 = page(MainPage.class);
        Assert.assertTrue("Не отобразился заголовок Булок", mainPage1.bunsSectionIsVisible());
        Assert.assertTrue("Не отобразился заголовок Соберите бургер", mainPage1.createBurgerIsVisible());
        Assert.assertTrue("Не отобразился заголовок Соусов", mainPage1.sauceSectionIsVisible());
        mainPage1.clickFillingsSectionHeader();
        Assert.assertTrue("Не отобразился заголовок Начинок", mainPage1.fillingsSectionIsVisible());

    }
}
