package com.hcid.edulearn.asksimple;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    RadioButton radioStudent;
    RadioButton radioTeacher;
    RadioButton radioTA;

    EditText Name;
    EditText UserID;
    EditText Password;
    EditText ConfirmPassword;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = (EditText) findViewById(R.id.name);
        UserID = (EditText) findViewById(R.id.user_id);
        Password = (EditText) findViewById(R.id.password);
        ConfirmPassword = (EditText) findViewById(R.id.confirm_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Disable custom toolbar shadow if API >= 21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.toolbar_shadow).setVisibility(View.GONE);
        }

        radioStudent = (RadioButton) findViewById(R.id.radio_student);
        radioTeacher = (RadioButton) findViewById(R.id.radio_teacher);
        radioTA = (RadioButton) findViewById(R.id.radio_ta);

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

        db = new DatabaseHandler(this);
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

    // TODO: add minimum name, user_id, password length check
    // TODO: check password against confirm password
    // TODO: Show thanks for registering screen, auto go back to login activity
    public void buttonRegister(View view) {
        String name = Name.getText().toString();
        String user_id = UserID.getText().toString();
        String password = Password.getText().toString();
        String confirm_password = ConfirmPassword.getText().toString();

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
            db.addUser(new User(name, user_id, password, type));
        } catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "User ID already exists!";
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, text, duration).show();
        }
    }
}
