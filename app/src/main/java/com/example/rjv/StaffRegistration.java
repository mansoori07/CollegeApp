package com.example.rjv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class StaffRegistration extends AppCompatActivity implements View.OnClickListener {


    private final AppCompatActivity activity = StaffRegistration.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout lay_Name;
    private TextInputLayout lay_Email;
    private TextInputLayout lay_Password;
    private TextInputLayout lay_ConfPassword;

    private EditText et_Name;
    private EditText et_Email;
    private EditText et_Password;
    private EditText et_ConfPassword;

    private AppCompatButton appCompatButtonRegister,appCompatLoginBtn;
    //private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DBHelper DB;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
        appCompatLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffRegistration.this,StaffLogin.class);
                //student.setVisibility(View.GONE);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);
        lay_Name = findViewById(R.id.lay_Name);
        lay_Email = findViewById(R.id.lay_Email);
        lay_Password = findViewById(R.id.lay_Password);
        lay_ConfPassword = findViewById(R.id.lay_ConfPassword);
        et_Name = findViewById(R.id.et_Name);
        et_Email = findViewById(R.id.et_Email);
        et_Password = findViewById(R.id.et_Password);
        et_ConfPassword = findViewById(R.id.et_ConfPassword);
        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);
        appCompatLoginBtn = findViewById(R.id.appCompatLoginBtn);

    }


    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatLoginBtn.setOnClickListener(this);

    }


    private void initObjects() {
        inputValidation = new InputValidation(activity);
        DB = new DBHelper(activity);
        user = new User();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatLoginBtn:
                finish();
                break;
        }
    }


    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(et_Name, lay_Name, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(et_Email, lay_Email, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(et_Email, lay_Email, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(et_Password, lay_Password, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(et_Password, et_ConfPassword,
                lay_ConfPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!DB.checkUser(et_Email.getText().toString().trim())) {

            user.setName(et_Name.getText().toString().trim());
            user.setEmail(et_Email.getText().toString().trim());
            user.setPassword(et_Password.getText().toString().trim());

            DB.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),AdminPanel.class);
            startActivity(intent);


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        et_Name.setText(null);
        et_Email.setText(null);
        et_Password.setText(null);
        et_ConfPassword.setText(null);
    }
}
