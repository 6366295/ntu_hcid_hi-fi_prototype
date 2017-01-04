package com.hcid.edulearn.asksimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CourseAddedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_added);
    }

    public void buttonEnter(View view) {
        Intent intent = new Intent(this, SessionActivity.class);
        startActivity(intent);
        finish();
    }

    public void buttonBack(View view) {
        finish();
    }
}

