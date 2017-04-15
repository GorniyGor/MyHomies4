package com.example.gor.myhomies2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.gor.myhomies2.Services.LoadService;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Service------------------------------------------






        // Скачиваем JSON и добавляем все ссылки из него в архив --------------------
        DownloadJSONAsync requestTask = new DownloadJSONAsync();
        mRecyclerView = new RecyclerView(this);
        mRecyclerAdapter = new RecyclerAdapter(getLayoutInflater());

        requestTask.setAdapter(mRecyclerAdapter);
        requestTask.execute(DownloadJSONAsync.JSON_URL);

        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mRecyclerView.setHasFixedSize(true);
        setContentView(mRecyclerView);



    }

}
