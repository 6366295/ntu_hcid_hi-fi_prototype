package com.hcid.edulearn.asksimple;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hcid.edulearn.asksimple.R;

import java.util.Random;

import butterknife.ButterKnife;

/**
 * Created by Lukas on 28/12/16.
 */

public class AnswersAdapter extends BaseAdapter {
    private Context context;

    public AnswersAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder holder;
        if(view != null){
            holder = (ViewHolder) view.getTag();
        }
        else {
            view = inflater.inflate(R.layout.adapter_answers_layout, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

        builder.setTitle(view.getResources().getString(R.string.yourAnswer))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppCompatEditText editText = (AppCompatEditText) ((AlertDialog)dialogInterface).findViewById(R.id.dialog_editText);
                        //Daryti ka reikia su text
                        if(editText.getText()!=null) {
                            holder.mAnswersText.setText(editText.getText());
                        }
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setView(R.layout.dialog_enter_text_layout);

        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                //Atsidarius answer editinima butu rodomas pries tai ivestas atsakymas
                AppCompatEditText editText = (AppCompatEditText) ((AlertDialog)dialogInterface).findViewById(R.id.dialog_editText);
                editText.setText(holder.mAnswersText.getText());
            }
        });

        //Random keisti į duomenų paėmimą ir sprendimą ka rodyti ir kada.
        Random random = new Random();
        if(random.nextInt(2)==0){
            holder.mEditButton.setVisibility(View.GONE);
            holder.mAuthorText.setText("By Aurimas");
            holder.mAuthorText.setTextColor(view.getResources().getColor(android.R.color.darker_gray));
        }
        else{
            holder.mEditButton.setVisibility(View.VISIBLE);
            holder.mEditButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.show();
                }
            });
            holder.mAuthorText.setText(R.string.yourAnswer);
            holder.mAuthorText.setTextColor(view.getResources().getColor(android.R.color.holo_green_dark));
        }
        return view;
    }

    static class ViewHolder {
        TextView mAnswersText;
        TextView mPublishDateText;
        TextView mAuthorText;
        ImageButton mEditButton;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
            mAnswersText = (TextView) view.findViewById(R.id.answersAdapter_answerText);
            mPublishDateText = (TextView) view.findViewById(R.id.answersAdapter_publishDateText);
            mAuthorText = (TextView) view.findViewById(R.id.answersAdapter_authorText);
            mEditButton = (ImageButton) view.findViewById(R.id.answersAdapter_editButton);
        }

    }

}