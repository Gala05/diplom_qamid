package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.LoveIsAllPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.pageObject.NewsPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsTest {
    LoginPage loginpage = new LoginPage();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    MainPage mainPage = new MainPage();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void authorisationInApp() {
        try {
            loginpage.appDownload();
        } catch (Exception e) {
            loginpage.exitFromApp();
        }
        loginpage.authorisationInApp();
        newsPage.goToNewsPageFromNavButton();
    }

    @Test
    public void readingNewsTest(){
        newsPage.goToNewsPageFromNavButton();
        newsPage.clickOnNews(0);
    }

    @Test
    public void addNews(){
        newsPage.addNews("Праздник", "Праздник5", "24.12.2024", "20:00", "Описание");
        //newsPage.openNews(0);
        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("Праздник5"),
                        //withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));

        newsPage.checkEditNews();
        textView.check(matches(withText("Праздник5")));


    }
}
