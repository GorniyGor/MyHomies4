package com.example.gor.myhomies3;


import android.os.AsyncTask;
import android.util.Log;

import com.example.gor.myhomies3.Services.NewImageCache;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class DownloadJSONAsync extends AsyncTask<String, Object, JSONArray> {
    public static final String JSON_URL = "http://188.166.49.215/tech/imglist.json";
    private static final String TAG = "myLogs";

    private RecyclerAdapter mRecyclerAdapter;

    public static int countOfImages = 0;

    @Override
    protected JSONArray doInBackground(String... params) {
        if (params != null && params.length > 0) {
            //Скачиваем файл
            HttpRequest request = new HttpRequest(params[0]);
            int status = request.makeRequest("JSON");

            Log.d(TAG, "Request");

            //Получаем из файла массив ссылок
            if (status == HttpRequest.REQUEST_OK) {
                JSONTokener jtk = new JSONTokener(request.getContent());
                Log.d(TAG, "There is gotten JSONTokener");
                try {
                    JSONArray jsonArray = (JSONArray) jtk.nextValue();
                    //countOfImages = jsonArray.length();//Это в onPostExecute---!!!!!!!!!!----
                    Log.d(TAG, "lenghtPUT = " + countOfImages);
                    return jsonArray;
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
            else Log.d(TAG, "REQUEST_ERROR");
        }

        Log.d(TAG, "Come out from doInBackgroud");


        return null;
    }

    @Override
    protected void onPostExecute(JSONArray linksArray) {

        countOfImages = linksArray.length();
        NewImageCache imageCache = NewImageCache.getInstance();
        Log.d(TAG, "onPostExecute");

        for (int i = 0; i < linksArray.length(); i++) {
            try {
                imageCache.setUrl(linksArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if(mRecyclerAdapter != null) mRecyclerAdapter.notifyDataSetChanged();
        else Log.d(TAG, "RecyclerAdapter is null");

    }

    public void setAdapter(RecyclerAdapter mRecyclerAdapter) {
        this.mRecyclerAdapter = mRecyclerAdapter;
    }
}
