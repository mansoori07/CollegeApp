package com.example.rjv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StaffLogin extends AppCompatActivity {

    EditText staffEmail,staffpasscode;
    Button StaffLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        this.setTitle("Staff Login");
        staffEmail=findViewById(R.id.staffEmail);
        staffpasscode=findViewById(R.id.staffpasscode);
        StaffLogin=(Button) findViewById(R.id.StaffLoginbtn);

        StaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valid=CheckAllFields();
                if(valid){
                    startActivity(new Intent(StaffLogin.this,StaffPanel.class));
                    finish();
                }
            }
        });

    }

    private boolean CheckAllFields() {
        if (staffEmail.length() == 0) {
            staffEmail.setError("This field is required");
            return false;
        }

        if (staffpasscode.length() == 0) {
            staffpasscode.setError("This field is required");
            return false;
        }


        // after all validation return true.
        return true;
    }
}