package com.newwavetech.architecturecomponentstest;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import java.util.List;

@Dao
public interface LeaveRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<LeaveRequests> leaveRequests);

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void save(LeaveRequests leaveRequest);

    @Query("Select * FROM LeaveRequests")
    LiveData<List<LeaveRequests>> selectAll();

}
