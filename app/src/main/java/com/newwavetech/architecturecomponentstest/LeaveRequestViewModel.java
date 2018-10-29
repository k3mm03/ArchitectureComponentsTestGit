package com.newwavetech.architecturecomponentstest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeaveRequestViewModel extends AndroidViewModel {

    private LeaveRequestDB database;

    public LeaveRequestViewModel(@NonNull Application application) {
        super(application);

        database = LeaveRequestDB.getInstance(this.getApplication());
    }

    LiveData<List<LeaveRequests>> getAllRequests(){
        return database.leaveRequestDao().selectAll();
    }

    void saveRequest(final LeaveRequests leaveRequest){
        new Thread(new Runnable() {
            @Override
            public void run() {
                database.leaveRequestDao().save(leaveRequest);
            }
        }).start();

    }

    void saveAllRequest(final List<LeaveRequests> leaveRequests){
        new Thread(new Runnable() {
            @Override
            public void run() {
                database.leaveRequestDao().saveAll(leaveRequests);
            }
        }).start();

    }
}
