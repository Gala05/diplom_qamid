package ru.iteco.fmhandroid.ui.pageObject;
import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

public class NewsPage {
    public static ViewInteraction navigationButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction newsButton = onView(withText("News"));
    public static ViewInteraction newsList = onView(withId(R.id.news_list_recycler_view));
    public static ViewInteraction newsEditButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction newsItemCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction newsItemTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction newsItemPublicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction newsItemPublicationTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction newsItemDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction viewNewsItem = onView(withId(R.id.view_news_item_image_view));

    public void goToNewsPageFromNavButton() {
        navigationButton.perform(click());
        newsButton.perform(click());
        checkNewsElements();
    }

    public void clickOnNews(int index) {
        newsList.perform(actionOnItemAtPosition(index,click()));
    }

    public void checkNewsElements(){
        newsEditButton.check(matches(isDisplayed()));
    }

    public void addNews(String category, String title, String publicationDate, String publicationTime, String description){
        newsEditButton.perform(click());
        addNewsButton.perform(click());
        newsItemCategory.perform(replaceText(category));
        newsItemTitle.perform(replaceText(title));
        newsItemPublicationDate.perform(replaceText(publicationDate));
        newsItemPublicationTime.perform(replaceText(publicationTime));
        newsItemDescription.perform(replaceText(description));
        saveButton.perform(click());
    }

    public void checkEditNews(){
        addNewsButton.check(matches(isDisplayed()));
    }
}
