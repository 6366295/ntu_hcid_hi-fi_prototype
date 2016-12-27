package com.hcid.edulearn.asksimple;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    View mSplashView;
    Button mButtonRegister;
    Animation fadeInAnimation;

    EditText UserID;
    EditText Password;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserID = (EditText) findViewById(R.id.user_id);
        Password = (EditText) findViewById(R.id.text_input_password);
        mSplashView = findViewById(R.id.layout_splash);
        splashAnimation();

        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setPaintFlags(mButtonRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        db = new DatabaseHandler(this);

        db.addUser(new User("student", "student", "student", "student"));
}

    public void buttonRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void buttonLogin(View view) {
        String user_id = UserID.getText().toString();

        User user = db.getUser(user_id);

        Log.d("Read: ", user_id);
//        Log.d("Read: ", user.getName());

        Intent intent = new Intent(this, CoursesActivity.class);
        startActivity(intent);
        finish();
    }

    public void splashAnimation() {
        // Load fade in animation from xml
        fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        // Special wrapper for layout weight change animation
        ViewWeightAnimationWrapper animationWrapper = new ViewWeightAnimationWrapper(mSplashView);

        // Make it layout fullscreen
        animationWrapper.setWeight(8);

        // Animate weight change
        ObjectAnimator anim = ObjectAnimator.ofFloat(
                animationWrapper,
                "weight",
                animationWrapper.getWeight(),
                4);

        anim.setInterpolator(new BounceInterpolator());

        // Delay animation for fade in to finish
        anim.setStartDelay(1500);

        // Set weight change animation duration
        anim.setDuration(1000);

        // Start animations
        mSplashView.startAnimation(fadeInAnimation);
        anim.start();
    }
}