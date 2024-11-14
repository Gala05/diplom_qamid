package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.click;

import static ru.iteco.fmhandroid.ui.pageObject.LoginPage.allNews;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.LoveIsAllPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.pageObject.NewsPage;

@RunWith(AllureAndroidJUnit4.class)
public class NavigationThroughSectionsTest {

    LoginPage loginpage = new LoginPage();
    AboutPage aboutPage = new AboutPage();
    MainPage mainPage = new MainPage();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    NewsPage newsPage = new NewsPage();
  
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
    }

    @Test
    public void fromMainToNewsTest(){
        newsPage.goToNewsPageFromNavButton();
    }

    @Test
    public void fromMainToAbout(){
        aboutPage.toAboutFromNavButton();
        aboutPage.backButtonInAbout();
        mainPage.checkingElemInMainPage();
    }

    @Test
    public void fromAllNewsInMainToNewsAndToMainTest(){
        allNews.perform(click());
        mainPage.toMainFromNavButton();
    }

    @Test
    public void fromMainToNewsToAboutTestTest() {
        newsPage.goToNewsPageFromNavButton();
        aboutPage.toAboutFromNavButton();
        aboutPage.backButtonInAbout();
        mainPage.checkingElemInMainPage();
    }

    @Test
    public void fromMainToLove(){
        loveIsAllPage.goToLoveIsAllPage();
    }

    @Test
    public void fromLoveToMain(){
        loveIsAllPage.goToLoveIsAllPage();
        mainPage.toMainFromNavButton();
    }

    @Test
    public void fromLoveToNews(){
        loveIsAllPage.goToLoveIsAllPage();
        newsPage.goToNewsPageFromNavButton();
    }

    @Test
    public void fromLoveToAbout(){
        loveIsAllPage.goToLoveIsAllPage();
        aboutPage.toAboutFromNavButton();
        aboutPage.backButtonInAbout();
        loveIsAllPage.checkingElemInLoveIsAllPage();
    }
}