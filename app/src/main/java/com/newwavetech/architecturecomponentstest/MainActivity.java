package com.newwavetech.architecturecomponentstest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.drm.DrmStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    private RecyclerView recyclerView;
    private MyAdapter recyclerviewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LeaveRequestViewModel leaveRequestViewModel;
    private FloatingActionButton faBtn;

    List<LeaveRequests> requestsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerviewAdapter = new MyAdapter(requestsList);
        recyclerView.setAdapter(recyclerviewAdapter);

        //get List from ViewModel
        leaveRequestViewModel = ViewModelProviders.of(this).get(LeaveRequestViewModel.class);

//        if(leaveRequestViewModel.getAllRequests().equals(null)){
//            Log.i(TAG, "onCreate: "+ leaveRequestViewModel.getAllRequests());
//            prepareData();
//        }

        leaveRequestViewModel.getAllRequests().observe(MainActivity.this, new Observer<List<LeaveRequests>>(){

            @Override
            public void onChanged(@Nullable List<LeaveRequests> requests) {
                recyclerviewAdapter.setData(requests);
            }
        });

        faBtn = findViewById(R.id.floatingActionButton);
        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActionAddActivity.class);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2){
           if(data == null){
               Log.i(TAG, "onActivityResult: No data passed!!");
           }
           else{ LeaveRequests obj = data.getParcelableExtra("object");

               leaveRequestViewModel.saveRequest(obj);}
        }
    }
}
