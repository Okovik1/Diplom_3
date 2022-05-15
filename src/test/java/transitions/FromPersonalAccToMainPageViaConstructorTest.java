package transitions;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellaburgerspageobject.MainPage;
import stellaburgerspageobject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class FromPersonalAccToMainPageViaConstructorTest {


    @Test
    @DisplayName("Transition from personal account to main page via Constructor label")
    public void fromPersonalAccToMainPageViaConstructorTest(){

        MainPage mainPage=
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);

        mainPage.clickButtonPersonalAccount();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickConstructor();

        MainPage mainPage1 = page(MainPage.class);
        mainPage1.bunsSectionIsVisible();
        mainPage1.createBurgerIsVisible();
        mainPage1.sauceSectionIsVisible();
        mainPage1.clickFillingsSectionHeader();
        mainPage1.fillingsSectionIsVisible();

    }
}

