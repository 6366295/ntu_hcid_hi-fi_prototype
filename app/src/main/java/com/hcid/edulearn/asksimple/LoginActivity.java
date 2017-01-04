package com.hcid.edulearn.asksimple;

import android.support.v7.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button buttonRegister;

    private Context appContext;

    private EditText editTextUserID;
    private EditText editTextPassword;

    private View viewSplash;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        appContext = getApplicationContext();

        viewSplash = findViewById(R.id.layout_splash);

        buttonRegister = (Button) findViewById(R.id.button_register);

        editTextUserID = (EditText) findViewById(R.id.user_id);
        editTextPassword = (EditText) findViewById(R.id.text_input_password);

        underlineButton();

        splashAnimation();

        createTempAppAccounts();
    }

    // Temporary testing accounts
    private void createTempAppAccounts() {
        db = new DatabaseHandler(this);

        try {
            db.addUser(new User("student", "student", "student", "student"));
            db.addUser(new User("teacher", "teacher", "teacher", "teacher"));
            db.addUser(new User("ta", "ta", "ta", "ta"));
        } catch (Exception e) {
            Log.d("Database", "Accounts already exists");
        }

        db.close();
    }

    private void underlineButton() {
        buttonRegister.setPaintFlags(buttonRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    private void showToast(CharSequence text) {
        int duration = Toast.LENGTH_SHORT;

        Toast.makeText(appContext, text, duration).show();
    }

    /**
     * Source: http://stackoverflow.com/questions/11506381/anyway-to-programmatically-animate-layout-weight-property-of-linear-layout.
     */
    private void splashAnimation() {
        // Load fade in animation from xml
        Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                                                                 R.anim.fade_in);

        // Special wrapper for layout weight change animation
        ViewWeightAnimationWrapper animationWrapper = new ViewWeightAnimationWrapper(viewSplash);

        // Make it layout fullscreen
        animationWrapper.setWeight(8);

        // Animate weight change
        ObjectAnimator anim = ObjectAnimator.ofFloat(animationWrapper,
                                                     "weight",
                                                     animationWrapper.getWeight(),
                                                     4);

        anim.setInterpolator(new BounceInterpolator());

        // Delay animation for fade in to finish
        anim.setStartDelay(1500);

        // Set weight change animation duration
        anim.setDuration(1000);

        // Start animations
        viewSplash.startAnimation(fadeInAnimation);
        anim.start();
    }

    public void buttonRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void buttonLogin(View view) {
        String user_id = editTextUserID.getText().toString();
        String password = editTextPassword.getText().toString();

        User user = db.getUser(user_id);

        try {
            Log.d("Read: ", user.getUserID());

            // Do not allow log in when user id is empty
            if(user_id.length() == 0) {
                throw new NullPointerException();
            }

            // Password correct
            if(password.equals(user.getPassword())) {
                showToast("Welcome " + user.getName());

                Intent intent = new Intent(this, CoursesActivity.class);
                intent.putExtra("user_id", user.getUserID());

                startActivity(intent);
                finish();
            } else {
                showToast("Password incorrect!");
            }
            // User id is not found in database
        } catch (NullPointerException e) {
            showToast("User ID does not exist!");
        }
    }
}