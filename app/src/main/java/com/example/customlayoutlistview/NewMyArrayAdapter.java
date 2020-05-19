package com.example.customlayoutlistview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;

import java.util.ArrayList;

public class NewMyArrayAdapter extends ArrayAdapter<Employee> {

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutId ;

    public NewMyArrayAdapter(Activity context, int layoutId, ArrayList<Employee>arr){
        super(context,layoutId,arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
          LayoutInflater inflater= context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        final TextView txtten = (TextView) convertView.findViewById(R.id.ten);
        final TextView txtgia = (TextView) convertView.findViewById(R.id.gia);
        final Employee emp=myArray.get(position);
        txtten.setText(emp.getFoodName());
        txtgia.setText(emp.getPrice());

    return convertView;
}

}
