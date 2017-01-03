package com.hcid.edulearn.asksimple;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Disable custom toolbar shadow if API >= 21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.toolbar_shadow).setVisibility(View.GONE);
        }
    }

    public void go_to_live_session(View view) {
        Intent intent = new Intent(this, LiveSessionActivity.class);
        startActivity(intent);
    }
}
