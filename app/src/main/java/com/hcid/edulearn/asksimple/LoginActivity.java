package com.hcid.edulearn.asksimple;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    View mSplashView;
    Button mButtonRegister;
    Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSplashView = findViewById(R.id.layout_splash);
        splashAnimation();

        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setPaintFlags(mButtonRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
}

    public void buttonRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void buttonLogin(View view) {
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