package com.example.gor.myhomies3;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gor.myhomies3.Services.LoadService;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
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
public class ExampleInstrumentedTest_Service {
    @Rule
    public ServiceTestRule mServiceRule = new ServiceTestRule();
    public LoadService service;

    @Before
    public void setUp() throws Exception{
        Intent startIntent = new Intent(InstrumentationRegistry.getTargetContext(), LoadService.class);
        IBinder binder = mServiceRule.bindService(startIntent);
        service = ((LoadService.MyBinder) binder).getService();
    }

    @After
    public void cleanUp() throws Exception{
        service = null;
        mServiceRule = null;
    }

    @Test
    public void initialService() throws Exception {
        Assert.assertNotNull(service);
    }


}
