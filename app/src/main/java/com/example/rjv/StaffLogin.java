package com.example.rjv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class StaffLogin extends AppCompatActivity {

    EditText staffEmail,staffpasscode;
    Button StaffLogin;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        this.setTitle("Staff Login");
        staffEmail=(EditText) findViewById(R.id.staffEmail);
        staffpasscode=(EditText) findViewById(R.id.staffpasscode);
        StaffLogin=(Button) findViewById(R.id.StaffLoginbtn);
        DB = new DBHelper(this);
        StaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = staffEmail.getText().toString();
                String pass = staffpasscode.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(StaffLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkUser(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(StaffLogin.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), StaffPanel.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(StaffLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}