package ru.iteco.fmhandroid.ui.test;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    LoginPage loginpage = new LoginPage();
    AboutPage aboutPage = new AboutPage();
    MainPage mainPage = new MainPage();

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
    public void checkingAllElemInAbout(){
        aboutPage.toAboutFromNavButton();
        aboutPage.backButtonInAbout();
        mainPage.checkingElemInMainPage();
    }

    @Test
    public void goToLinkPrivacyPolicy(){
        Intents.init();
        aboutPage.toAboutFromNavButton();
        aboutPage.goToTheLinkPrivacyPolicy();
        Intents.release();
    }

    @Test
    public void goToLinkTermsOfUse(){
        Intents.init();
        aboutPage.toAboutFromNavButton();
        aboutPage.goToLinkTermsOfUse();
        Intents.release();
    }
}
