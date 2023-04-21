package com.example.rjv;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StaffPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_panel);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_barStaff);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.StaffhomeBtn:
                            selectedFragment = new StaffHomeFragment();
                            break;
                        case R.id.StaffnewsBtn:
                            selectedFragment = new StaffNewsFragment();
                            break;
                        case R.id.StaffUploadBtn:
                            selectedFragment = new StaffUploadFragment();
                            break;
                        case R.id.StaffnotificationBtn:
                            selectedFragment = new StaffNotificationFragment();
                            break;
                        case R.id.StaffprofileBtn:
                            selectedFragment = new StaffProfileFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerstaff, selectedFragment).commit();

                    return true;

                }
            };

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerstaff, new StaffHomeFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(StaffPanel.this, MainActivity.class));


    }
}