package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class MainTest {
    LoginPage loginpage = new LoginPage();
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
    public void newsDropdownInMain(){
        mainPage.newsDropdownButtonInMain();
    }
}

