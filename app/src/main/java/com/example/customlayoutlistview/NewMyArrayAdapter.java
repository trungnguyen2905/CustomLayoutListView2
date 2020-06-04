package com.example.customlayoutlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewMyArrayAdapter extends ArrayAdapter<Foods> {

    Activity context = null;
    ArrayList<Foods> myArray = null;
    int layoutId ;

    public NewMyArrayAdapter(Activity context, int layoutId, ArrayList<Foods>arr){
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
        final Foods foods=myArray.get(position);
        txtten.setText(foods.getFoodName());
        txtgia.setText(foods.getPrice());

    return convertView;
}

}
