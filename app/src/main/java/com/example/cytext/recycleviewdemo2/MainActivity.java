package com.example.cytext.recycleviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        loadListData();

    }

    private void loadListData() {
//            给recycleview加载数据
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            DataBean dataBean = new DataBean();
            dataBean.pic = R.mipmap.ic_launcher;
            dataBean.name = "图片名-" + i;
            list.add(dataBean);
        }
//        1.设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        //是否为反向显示数据
//        layoutManager.setReverseLayout(true);
        //是否为水平或垂直显示数据
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
//        2.设置适配器
        ListAdapter listAdaper = new ListAdapter(this, list);
        recyclerView.setAdapter(listAdaper);

    }
}
