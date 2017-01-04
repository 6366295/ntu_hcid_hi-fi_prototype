package com.hcid.edulearn.asksimple;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Context appContext;

    private EditText editTextName;
    private EditText editTextUserID;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    private RadioButton radioStudent;
    private RadioButton radioTeacher;
    private RadioButton radioTA;

    DatabaseHandler db;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        appContext = getApplicationContext();

        editTextName = (EditText) findViewById(R.id.name);
        editTextUserID = (EditText) findViewById(R.id.user_id);
        editTextPassword = (EditText) findViewById(R.id.password);
        editTextConfirmPassword = (EditText) findViewById(R.id.confirm_password);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        radioStudent = (RadioButton) findViewById(R.id.radio_student);
        radioTeacher = (RadioButton) findViewById(R.id.radio_teacher);
        radioTA = (RadioButton) findViewById(R.id.radio_ta);

        // Enable back button in toolbar
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setRadioButtons();
    }

    // Source: http://stackoverflow.com/questions/26651602/display-back-arrow-on-toolbar-android
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private void showToast(CharSequence text) {
        int duration = Toast.LENGTH_SHORT;

        Toast.makeText(appContext, text, duration).show();
    }

    private void setRadioButtons() {
        radioStudent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                radioStudent.setChecked(true);
                radioTeacher.setChecked(false);
                radioTA.setChecked(false);
            }
        });

        radioTeacher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                radioStudent.setChecked(false);
                radioTeacher.setChecked(true);
                radioTA.setChecked(false);
            }
        });

        radioTA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                radioStudent.setChecked(false);
                radioTeacher.setChecked(false);
                radioTA.setChecked(true);
            }
        });
    }

    public void buttonRegister(View view) {
        db = new DatabaseHandler(this);

        String name = editTextName.getText().toString();
        String user_id = editTextUserID.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirm_password = editTextConfirmPassword.getText().toString();

        // Default account type
        String type = "student";

        if (radioStudent.isChecked()) {
            type = "student";
        } else if (radioTeacher.isChecked()) {
            type = "teacher";
        } else if (radioTA.isChecked()) {
            type = "ta";
        }

        try {
            Log.d("db.addUser", "name: " + name);
            Log.d("db.addUser", "user_id: " + user_id);
            Log.d("db.addUser", "password: " + password);
            Log.d("db.addUser", "confirm_password: " + confirm_password);
            Log.d("db.addUser", "type: " + type);

            if(name.length() < 1 || user_id.length() < 1 || password.length() < 1) {
                showToast("Name, User ID and password needs to have a minimum length of 1!");
            } else {
                if(password.equals(confirm_password)) {
                    db.addUser(new User(name, user_id, password, type));

                    Intent intent = new Intent(this, RegisteredActivity.class);

                    startActivity(intent);
                    finish();
                } else {
                    showToast("Passwords do not match!");
                }
            }
        // Check if user already exists
        } catch (Exception e) {
            Log.d("buttonRegister", e.getMessage());

            showToast("User ID already exists!");
        }
    }
}
