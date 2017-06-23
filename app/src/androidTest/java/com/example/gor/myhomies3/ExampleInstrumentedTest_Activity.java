package com.example.gor.myhomies3;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest_Activity {

    @Rule // Почему так различаются правила Activity и Service ?----------
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void initialState() throws Exception {
        final Activity activity = mActivityRule.launchActivity(
                new Intent(InstrumentationRegistry.getTargetContext(), MainActivity.class));
        Assert.assertNotNull(activity.getLayoutInflater());
    }
}
