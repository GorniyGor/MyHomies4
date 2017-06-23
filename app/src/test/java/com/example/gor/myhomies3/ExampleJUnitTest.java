package com.example.gor.myhomies3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleJUnitTest {

    HttpRequest request;
    int status;
    String JSON_URL;

    @Before
    public void init(){
        JSON_URL = "http://188.166.49.215/tech/imglist.json"; // test passed
        JSON_URL = "sdcawvcaevca"; // test failed
        request = new HttpRequest(JSON_URL);
        status = request.makeRequest("JSON");
    }

    @After
    public void cleanup(){
        JSON_URL = null;
        request = null;
        status = 0;
    }

    @Test
    public void httpRequestTest() throws Exception {
        if (status != HttpRequest.REQUEST_OK) Assert.assertTrue(false);
    }
}