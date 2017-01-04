package com.hcid.edulearn.asksimple;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class coursesArrayAdapter extends ArrayAdapter<Course> {

    private Context context;
    private List<Course> courses;

    //constructor, call on creation
    public coursesArrayAdapter(Context context, int resource, ArrayList<Course> objects) {
        super(context, resource, objects);

        this.context = context;
        this.courses = objects;
    }

    // called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        Course course = courses.get(position);

        // get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.courselist_item, null);

        TextView courseName = (TextView) view.findViewById(R.id.courseName);
        TextView startDate = (TextView) view.findViewById(R.id.startDate);
        ImageView infoImage = (ImageView) view.findViewById(R.id.infoImage);
        TextView active = (TextView) view.findViewById(R.id.active);
//        LinearLayout rectBar = (LinearLayout) view.findViewById(R.id.rectBar);

        // set attributes
        int nameLength = course.getName().length();
        if (nameLength >= 60){
            String nameTrim = course.getName().substring(0, 60) + "...";
            courseName.setText(nameTrim);
        } else{
            courseName.setText(course.getName());
        }
        SimpleDateFormat ft = new SimpleDateFormat("dd MMM kk:mm");
        startDate.setText(ft.format(course.getStartDate()));

        if (course.getSessionActive()) {
            active.setText("Active");
            active.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_corner));
//            active.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen));
//            rectBar.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen));
        } else {
            active.setText("");
        }
        active.setPadding(30,6,30,6);

        return view;
    }
}