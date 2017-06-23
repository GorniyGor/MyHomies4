package com.example.gor.myhomies3;

import android.content.Context;
import android.content.Intent;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Gor on 21.06.2017.
 */

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UIAutomatorTest {

    public UiDevice mDevice;
    private static final String PACKAGE =
            "com.example.gor.myhomies3";
    public static int LAST_ITEM_ID;

    @Before
    public void startActivity(){
        LAST_ITEM_ID = DownloadJSONAsync.countOfImages-1;
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                5000 );

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)),
                5000);
    }

    @Test
    public void checkPreconditions(){
        Assert.assertNotNull(mDevice);
    }

    @Test
    public void listScroll() throws UiObjectNotFoundException {
//      Assert.assertTrue(new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(LAST_ITEM_ID));
        Assert.assertTrue(new UiScrollable(new UiSelector().scrollable(true))
                .scrollIntoView(new UiSelector().index(0)));
    }

}
