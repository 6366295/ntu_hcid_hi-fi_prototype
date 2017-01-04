package com.hcid.edulearn.asksimple;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView startTxt = (TextView) view.findViewById(R.id.startTxt);
        TextView startDate = (TextView) view.findViewById(R.id.startDate);
        ImageView infoImage = (ImageView) view.findViewById(R.id.infoImage);

        // set attributes
        courseName.setText(course.getName());
        startTxt.setText("Started: ");
        startDate.setText(course.getStartDate().toString());

        return view;
    }
}