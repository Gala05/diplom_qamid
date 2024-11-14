package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.Data.authorizationEmptyFieldsMessage;
import static ru.iteco.fmhandroid.ui.data.Data.emptyField;
import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.regSQLInjection;
import static ru.iteco.fmhandroid.ui.data.Data.toastMessageUnregisteredUser;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matchers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.LoginPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;


@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Before
    public void authorisationInApp() {
        try {
            loginPage.appDownload();
        } catch (Exception e) {
            loginPage.exitFromApp();
        }
        //loginPage.authorisationInApp()
    }
    @Test
    public void authorizationRegisteredUserTest() {
        loginPage.authorisationInApp();
        mainPage.checkingElemInMainPage();
        loginPage.exitFromApp();
    }

    @Test
    public void authorizationUnregisteredUserTest() {
        loginPage.authorisationMistakeInApp(invalidLogin, invalidPassword);
        onView(withText(toastMessageUnregisteredUser))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void authorizationInvalidLoginValidPasswordTest() {
        loginPage.authorisationMistakeInApp(invalidLogin, validPassword);
        onView(withText(toastMessageUnregisteredUser))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void authorizationValidLoginInvalidPasswordTest() {
        loginPage.authorisationMistakeInApp(validLogin, invalidPassword);
        onView(withText(toastMessageUnregisteredUser))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void authorizationEmptyFieldsTest() {
        loginPage.authorisationMistakeInApp(emptyField, emptyField);
        onView(withText(authorizationEmptyFieldsMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void authorizationWithSQLInjectionInLoginTest() {
        loginPage.authorisationMistakeInApp(regSQLInjection, validPassword);
        onView(withText(toastMessageUnregisteredUser))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void authorizationWithSQLInjectionInPasswordTest() {
        loginPage.authorisationMistakeInApp(validLogin, regSQLInjection);
        onView(withText(toastMessageUnregisteredUser))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
}
