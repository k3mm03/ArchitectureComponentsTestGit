package com.newwavetech.architecturecomponentstest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {LeaveRequests.class}, version = 1, exportSchema = false)
public abstract class LeaveRequestDB extends RoomDatabase {

    private static LeaveRequestDB INSTANCE;

    public abstract LeaveRequestDao leaveRequestDao();

    private static final Object obj = new Object();

    public static LeaveRequestDB getInstance(Context context){

        synchronized (obj){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LeaveRequestDB.class, "LeaveRequests.db")
                        .allowMainThreadQueries()
                        .build();
            }
            return INSTANCE;
        }

    }

}
