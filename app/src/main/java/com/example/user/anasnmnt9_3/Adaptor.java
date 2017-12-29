package com.example.user.anasnmnt9_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.ArrayList;

/**
 * Created by IIS 5 on 02-09-2017.
 */
//creating adaptor class
public class Adaptor extends BaseAdapter{
    //implementing the arrayllist and layout inflator
    ArrayList<Student> mArrayList;
    LayoutInflater mLayoutInflater;

    public Adaptor(Context context, ArrayList<Student> mArrayList) {
        this.mArrayList=mArrayList;
        this.mLayoutInflater=LayoutInflater.from(context);
    }


    //it returns the size of the arraylist
    @Override
    public int getCount() {

        return mArrayList.size();
    }
    //it gets the arraylist position
    @Override
    public Object getItem(int position)
    {
        return mArrayList.get(position);
    }
    //here it sets the item position
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    //to view the context list
    public View getView(int position, View convertView , ViewGroup parent){
        convertView=mLayoutInflater.inflate(R.layout.customlistview,parent,false);

        Student student= (Student)getItem(position);

        TextView name=(TextView)convertView.findViewById(R.id.name);
        TextView phone=(TextView)convertView.findViewById(R.id.phone);

        name.setText(student.getName());

        phone.setText(String.valueOf(student.getPhone()));

        return convertView;
    }
}