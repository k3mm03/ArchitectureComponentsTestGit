package com.newwavetech.architecturecomponentstest;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<LeaveRequests> requests;

    public MyAdapter(List<LeaveRequests> requests){this.requests = requests;}

    public void setData(List<LeaveRequests> list){
        this.requests = list;
        notifyDataSetChanged();}

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View requestView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(requestView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder mviewHolder, int i) {
        mviewHolder.employeeId.setText(requests.get(i).getRequestId()+"");
        mviewHolder.employeeName.setText(requests.get(i).getEmployeeName());
        mviewHolder.leavePeriod.setText(requests.get(i).getLeavePeriod()+"");
        mviewHolder.description.setText(requests.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView employeeId,employeeName, leavePeriod, description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeId = itemView.findViewById(R.id.employeeId_tv);
            employeeName = itemView.findViewById(R.id.employeeName_tv);
            leavePeriod = itemView.findViewById(R.id.leavePeriod_tv);
            description = itemView.findViewById(R.id.description_tv);

        }
    }

}
