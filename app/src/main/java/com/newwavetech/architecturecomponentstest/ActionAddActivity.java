package com.newwavetech.architecturecomponentstest;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActionAddActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText employeeName, leavePeriod, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_action_add);

        LeaveRequestViewModel leaveRequestViewModel = ViewModelProviders.of(this).get(LeaveRequestViewModel.class);

        employeeName = findViewById(R.id.employeeName_ed);
        leavePeriod = findViewById(R.id.leavePeriod_ed);
        description = findViewById(R.id.description_ed);

        submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String empName = employeeName.getText().toString();
                int period = Integer.parseInt(leavePeriod.getText().toString());
                String desc = description.getText().toString();
                LeaveRequests request = new LeaveRequests();
                request.setEmployeeName(empName); request.setLeavePeriod(period); request.setDescription(desc);

                Intent intent = new Intent();
                intent.putExtra("object",  request);
                setResult(2, intent);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
