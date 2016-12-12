package com.hcid.edulearn.asksimple;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    View mSplashView;
    Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSplashView = findViewById(R.id.layout_splash);

        splashAnimation();
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

        // Delay animation for fade in to finish
        anim.setStartDelay(1500);

        // Set weight change animation duration
        anim.setDuration(1000);

        // Start animations
        mSplashView.startAnimation(fadeInAnimation);
        anim.start();
    }
}