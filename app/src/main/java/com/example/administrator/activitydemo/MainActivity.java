package com.example.administrator.activitydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"
    };
    private int[] res = {R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.watermelon,
            R.drawable.pear, R.drawable.grape, R.drawable.pineapple, R.drawable.strawberry, R.drawable.cherry, R.drawable.mango,
            R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.watermelon,
            R.drawable.pear, R.drawable.grape, R.drawable.pineapple, R.drawable.strawberry, R.drawable.cherry, R.drawable.mango};
    private List<Fruit> fruitList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化UI控件
        initData();//初始化数据
    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        initFruits();//初始化水果数据
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);//3列，垂直
        recyclerView.setLayoutManager(layoutManager);//为RecyclerView控件设置布局管理器
        FruitAdapter adapter = new FruitAdapter(fruitList);//实例化适配器
        recyclerView.setAdapter(adapter);//为RecyclerView控件设置适配器
    }

    private void initFruits() {
        fruitList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Fruit fruit = new Fruit(getRandomLengthName(data[i]), res[i]);
            fruitList.add(fruit);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;//取0~20之间的一个随机数
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);//字符串拼接
        }
        return builder.toString();
    }

}


