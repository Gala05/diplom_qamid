package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.Data.addNewsEmptyFieldsMessage;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.LoveIsAllPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.pageObject.NewsPage;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    LoginPage loginpage = new LoginPage();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    MainPage mainPage = new MainPage();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void authorisationInApp() {
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
        try {
            loginpage.appDownload();
        } catch (Exception e) {
            loginpage.exitFromApp();
        }
        loginpage.authorisationInApp();
        newsPage.goToNewsPageFromNavButton();
    }

//    @Test
//    public void readingNewsTest(){
//        newsPage.goToNewsPageFromNavButton();
//        newsPage.clickOnNews(0);
//    }

    @Test
    public void addNews(){
        newsPage.addNews();
        newsPage.checkEditNews();
        newsPage.filterNews();
        newsPage.checkAddedNewsInControlPanel();
    }

    @Test
    public void addNewsWithEmptyFields(){
        newsPage.addNewsWithEmptyFields();
        newsPage.checkEmptyFieldsMessage();
    }

    @Test
    public void deleteNewsWithTodayPublicationDate(){
        newsPage.addNewsWithTodayPublicationDateAndSort();
        newsPage.filterTodayNews();
        newsPage.checkAddedNewsInControlPanel();
        newsPage.deleteNews();
        newsPage.checkAddedNewsIsDeleted();

    }

    @Test
    public void changeNews(){
        newsPage.addNewsWithTodayPublicationDateAndSort();
        newsPage.filterTodayNews();
        newsPage.checkAddedNewsInControlPanel();
        newsPage.checkEditNews();
        newsPage.editNews();
        newsPage.checkAddedNewsIsEditedInControlPanel();
    }
}
