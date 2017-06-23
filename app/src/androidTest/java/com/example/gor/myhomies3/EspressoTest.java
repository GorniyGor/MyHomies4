package com.example.gor.myhomies3;

import android.support.test.espresso.DataInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

/**
 * Created by Gor on 21.06.2017.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    public static int LAST_ITEM_ID;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class, false, true);

    @Before
    public void setUp() throws Exception{
        LAST_ITEM_ID = DownloadJSONAsync.countOfImages-1;
    }

    @After
    public void cleanUp() throws Exception{
        LAST_ITEM_ID = 0;
    }

    /**
     * Test that the list is long enough for this sample, the last item shouldn't appear.
     */
    @Test
    public void lastItemNotDisplayed(){
        // Last item should not exist if the list wasn't scrolled down.
        onView(withId(LAST_ITEM_ID)).check(doesNotExist());
    }

    // Не совсем понял это в примере github: googlesamples/android-testing/DataAdapterSample
   /*
     * Check that the item is created. onData() takes care of scrolling.

    @Test
    public void list_Scrolls() {
        onRow(LAST_ITEM_ID).check(matches(isCompletelyDisplayed()));
    }

    private static DataInteraction onRow(int id){
        return onData(hasEntry(equalTo(LongListActivity.ROW_TEXT), is(str)));
    }*/
}
