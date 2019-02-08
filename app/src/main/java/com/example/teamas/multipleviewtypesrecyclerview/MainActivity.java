package com.example.teamas.multipleviewtypesrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView callSmsRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> callSmsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initObjects();
        initRecycler();
        initAdapter();


    }

    private void initAdapter() {
        CallSmsAdapter callSmsAdapter = new CallSmsAdapter(this, callSmsList);
        callSmsRecyclerView.setAdapter(callSmsAdapter);
    }

    private void initRecycler() {
        linearLayoutManager = new LinearLayoutManager(this);
        callSmsRecyclerView.setLayoutManager(linearLayoutManager);
        callSmsRecyclerView.setHasFixedSize(true);
    }

    private void initObjects() {
        callSmsList = new ArrayList<Object>();
        callSmsList.add(new Call("John", "9:45 am"));
        callSmsList.add(new Call("Johnny", "11:45 am"));
        callSmsList.add(new Sms("Hanan Bhai", "Hello", "3:00 am"));
        callSmsList.add(new Call("David", "1:45 pm"));
        callSmsList.add(new Sms("Ali", "Kaisa hai?", "5:10 pm"));

    }

    private void initViews() {
        callSmsRecyclerView = findViewById(R.id.callSmsRecyclerView);
    }
}
