package transitions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellaburgerspageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class TransitionsToBunsSaucesFillingsSectionsTest {

    @Test
    @DisplayName("Transition to Bans, sauces,fillings")
    public void transitionsToBunsSaucesFillingsSectionsTest() throws InterruptedException {
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site/",
                        MainPage.class);
        //Проверка перехода на секцию Соусы
        mainPage.clickSauceSection();
        mainPage.sauceSectionIsVisible();

        //Проверка перехода на секцию Начинки
        mainPage.clickFillingsSectionHeader();
        mainPage.fillingsSectionIsVisible();

        //Проверка перехода на секцию булок
        mainPage.clickBunsSectionHeader();
        mainPage.bunsSectionIsVisible();


    }
}
