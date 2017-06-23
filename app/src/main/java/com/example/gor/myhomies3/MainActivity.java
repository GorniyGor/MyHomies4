package com.example.gor.myhomies3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
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
