package com.hcid.edulearn.asksimple;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class LiveSessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_session);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Disable custom toolbar shadow if API >= 21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.toolbar_shadow).setVisibility(View.GONE);
        }
    }

    public void ask_question(View view) {

    }

    public void go_to_the_question(View view) {

    }

    public void click_1(View view) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        if(tv.getText() == "29"){
            iv.setImageResource(R.drawable.like);
            tv.setText("30");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("29");
        }
    }

    public void click_2(View view) {
        TextView tv = (TextView) findViewById(R.id.textView2);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        if(tv.getText() == "3"){
            iv.setImageResource(R.drawable.like);
            tv.setText("4");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("3");
        }
    }

    public void click_3(View view) {
        TextView tv = (TextView) findViewById(R.id.textView3);
        ImageView iv = (ImageView) findViewById(R.id.imageView3);
        if(tv.getText() == "16"){
            iv.setImageResource(R.drawable.like);
            tv.setText("17");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("16");
        }
    }

    public void click_4(View view) {
        TextView tv = (TextView) findViewById(R.id.textView4);
        ImageView iv = (ImageView) findViewById(R.id.imageView4);
        if(tv.getText() == "0"){
            iv.setImageResource(R.drawable.like);
            tv.setText("1");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("0");
        }
    }
}
