package com.example.yuan.moreitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        HttpSingleton.getInstance().doGet(url, new HttpSingleton.UtilListener() {
            @Override
            public void succeed(String json) {
                Gson gson = new Gson();
                Bean fromJson = gson.fromJson(json, Bean.class);
                List<Bean.DataBean> data = fromJson.getData();

                RecycleViewAdapter adapter = new RecycleViewAdapter(MainActivity.this,data);
                recycle.setAdapter(adapter);

                recycle.setLayoutManager
                        (new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
            }

            @Override
            public void fail(Exception e) {

            }
        });
    }

    String url = "http://www.xieast.com/api/news/news.php?page=1";

    private void initView() {
        recycle = (RecyclerView) findViewById(R.id.recycle);
    }
}
