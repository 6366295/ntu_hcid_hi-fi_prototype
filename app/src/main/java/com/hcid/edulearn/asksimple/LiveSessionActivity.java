package com.hcid.edulearn.asksimple;

import android.graphics.Color;
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

        // set texts
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setText("29");
        tv1.setTextColor(Color.BLACK);

        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText("16");
        tv2.setTextColor(Color.RED);

        TextView tv3 = (TextView) findViewById(R.id.textView3);
        tv3.setText("13");
        tv3.setTextColor(Color.BLACK);

        TextView tv4 = (TextView) findViewById(R.id.textView4);
        tv4.setText("10");
        tv4.setTextColor(Color.BLACK);
    }

    public void ask_question(View view) {

    }

    public void go_to_the_question(View view) {

    }

    public void click_1(View view) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        if(tv.getText() == "29"){
            iv.setImageResource(R.drawable.like_ab);
            tv.setText("30");
            tv.setTextColor(Color.RED);
        }else{
            iv.setImageResource(R.drawable.like_aa);
            tv.setText("29");
            tv.setTextColor(Color.BLACK);
        }
    }

    public void click_2(View view) {
        TextView tv = (TextView) findViewById(R.id.textView2);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        if(tv.getText() == "15"){
            iv.setImageResource(R.drawable.like_ab);
            tv.setText("16");
            tv.setTextColor(Color.RED);
        }else{
            iv.setImageResource(R.drawable.like_aa);
            tv.setText("15");
            tv.setTextColor(Color.BLACK);
        }
    }

    public void click_3(View view) {
        TextView tv = (TextView) findViewById(R.id.textView3);
        ImageView iv = (ImageView) findViewById(R.id.imageView3);
        if(tv.getText() == "13"){
            iv.setImageResource(R.drawable.like_ab);
            tv.setText("14");
            tv.setTextColor(Color.RED);
        }else{
            iv.setImageResource(R.drawable.like_aa);
            tv.setText("13");
            tv.setTextColor(Color.BLACK);
        }
    }

    public void click_4(View view) {
        TextView tv = (TextView) findViewById(R.id.textView4);
        ImageView iv = (ImageView) findViewById(R.id.imageView4);
        if(tv.getText() == "10"){
            iv.setImageResource(R.drawable.like_ab);
            tv.setText("11");
            tv.setTextColor(Color.RED);
        }else{
            iv.setImageResource(R.drawable.like_aa);
            tv.setText("10");
            tv.setTextColor(Color.BLACK);
        }
    }
}
