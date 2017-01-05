package com.hcid.edulearn.asksimple;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ScrollingActivity extends AppCompatActivity {
    private ListView mAnswersListView;
    private TextView mQuestionText;
    private ImageButton mThumbUpIcon;
    private TextView mThumbUpText;
    private TextView mAnswersCountText;
    private AnswersAdapter mAnswersAdapter;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAnswersListView = (ListView) findViewById(R.id.QAFragment_answersList);
        mQuestionText = (TextView) findViewById(R.id.QAFragment_questionText);
        mThumbUpIcon = (ImageButton) findViewById(R.id.QAFragment_thumbUpIcon);
        mThumbUpText = (TextView) findViewById(R.id.QAFragment_thumbUpText);
        mAnswersCountText = (TextView) findViewById(R.id.QAFragment_answersCountText);
        mFab = (FloatingActionButton) findViewById(R.id.QAFragment_fab);

        mAnswersAdapter = new AnswersAdapter(getBaseContext());
        mAnswersListView.setAdapter(mAnswersAdapter);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getResources().getString(R.string.question))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppCompatEditText editText = (AppCompatEditText) ((AlertDialog)dialogInterface).findViewById(R.id.dialog_editText);
                        //Daryti ka reikia su text
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setView(R.layout.dialog_enter_text_layout);

        final AlertDialog alertDialog = builder.create();

        mThumbUpIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text  = (String) mThumbUpText.getText();
                int number;
                if(text != null){
                    number = Integer.parseInt(text);
                }else{
                    number = 0;
                }
                number +=1;
                mThumbUpText.setText("" + number);
                mThumbUpIcon.setColorFilter(getResources().getColor(android.R.color.darker_gray));
                //Prideti skaiciaus reagavima, i realiu duomenis, taip pat invertavima pagal isorini faktoriu
                alertDialog.show();                //Cia siaip sau sitoje vietoje padariau kad iskviestu klausimo pridejima
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(R.string.yourAnswer);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
//        return true;
//    }

    // Source: http://stackoverflow.com/questions/26651602/display-back-arrow-on-toolbar-android
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}