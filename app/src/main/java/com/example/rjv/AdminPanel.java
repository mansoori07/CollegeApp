package com.example.rjv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AdminPanel extends AppCompatActivity {

    CardView registerStaff,registerStudent,studentInfo,uploadNews,uploadNotification,staffInfo,addAdmin,logoutAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        this.setTitle("Admin Panel");
        registerStaff=findViewById(R.id.registerStaff);
        registerStudent=findViewById(R.id.registerStudent);
        studentInfo=findViewById(R.id.StudentInfo);
        addAdmin=findViewById(R.id.addadmin);
        logoutAdmin=findViewById(R.id.logoutAdmin);
        staffInfo=findViewById(R.id.StaffInfo);
        uploadNews=findViewById(R.id.UploadNews);
        uploadNotification=findViewById(R.id.uploadNotification);

        registerStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,StaffRegistration.class);
                startActivity(i);
            }
        });
        registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,StudentRegistration.class);
                startActivity(i);
            }
        });
        studentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,StudentInfo.class);
                startActivity(i);
            }
        });
        staffInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,StaffInfo.class);
                startActivity(i);
            }
        });
        uploadNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,UploadNewsAdmin.class);
                startActivity(i);
            }
        });
        uploadNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,UploadNotificationAdmin.class);
                startActivity(i);
            }
        });
        logoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FirebaseAuth.getInstance().signOut();

                startActivity(new Intent(AdminPanel.this,MainActivity.class));
                Toast.makeText(AdminPanel.this, "Logged Out... Please login", Toast.LENGTH_SHORT).show();

            }
        });
        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel.this,AddAdmin.class);
                startActivity(i);


            }
        });

    }
}