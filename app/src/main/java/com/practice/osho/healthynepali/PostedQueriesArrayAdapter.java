package com.practice.osho.healthynepali;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.parse.ParseObject;

/**
 * Created by osho on 10/19/15.
 */
public class PostedQueriesArrayAdapter extends ArrayAdapter<ParseObject> {

    private final Context context;
    private final ArrayList<ParseObject> values;

    public PostedQueriesArrayAdapter(Context context, ArrayList<ParseObject> list){
        super(context,R.layout.posted_queries_rowlayout,list);
        this.context=context;
        this.values=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.posted_queries_rowlayout,parent,false);

        TextView tv_postedDate = (TextView)rowView.findViewById(R.id.tv_postedDate);
        TextView tv_postedQuery = (TextView) rowView.findViewById(R.id.tv_postedQuery);

        String date = values.get(position).getCreatedAt().toString();

        String posts = values.get(position).getString("questions");

        tv_postedDate.setText(date);
        tv_postedQuery.setText(posts);



        return rowView;
    }
}
