package com.example.rjv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button student;
    Button Teacher,Admin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("CGC JHANJERI");
        student=(Button) findViewById(R.id.btnstudent);
        Teacher=(Button) findViewById(R.id.btnStaff);
        Admin=(Button) findViewById(R.id.btnAdmin);

        Teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StaffLogin.class);
                //student.setVisibility(View.GONE);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StudentLogin.class);
                //management.setVisibility(View.GONE);
                startActivity(intent);

            }
        });
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdminSignUp.class);
                //management.setVisibility(View.GONE);
                startActivity(intent);

            }
        });

    }
}