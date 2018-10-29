package com.newwavetech.architecturecomponentstest;

import android.arch.persistence.room.*;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

@Entity
public class LeaveRequests implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int requestId;
    private String employeeName;
    private int leavePeriod;
    private String description;

    public  LeaveRequests(){}

    @Ignore
    public LeaveRequests(String employeeName, int leavePeriod, String description) {
        this.employeeName = employeeName;
        this.leavePeriod = leavePeriod;
        this.description = description;
    }

    protected LeaveRequests(Parcel in) {
        requestId = in.readInt();
        employeeName = in.readString();
        leavePeriod = in.readInt();
        description = in.readString();
    }

    public static final Creator<LeaveRequests> CREATOR = new Creator<LeaveRequests>() {
        @Override
        public LeaveRequests createFromParcel(Parcel in) {
            return new LeaveRequests(in);
        }

        @Override
        public LeaveRequests[] newArray(int size) {
            return new LeaveRequests[size];
        }
    };

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLeavePeriod() {
        return leavePeriod;
    }

    public void setLeavePeriod(int leavePeriod) {
        this.leavePeriod = leavePeriod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(requestId);
        dest.writeString(employeeName);
        dest.writeInt(leavePeriod);
        dest.writeString(description);
    }
}
