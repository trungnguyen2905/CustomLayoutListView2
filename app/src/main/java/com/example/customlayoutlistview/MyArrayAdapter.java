package com.example.customlayoutlistview;

import android.app.Activity;
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

public class MyArrayAdapter extends ArrayAdapter<Foods> {

    Activity context = null;
    ArrayList<Foods> myArray = null;
    int layoutId ;
    CheckBox checkBox;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<Foods>arr){
        super(context,layoutId,arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }
    private View.OnClickListener foodOnclick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.txtitem:
                    String fl=(String)v.getTag();
                    Toast.makeText(context,fl.toString(),Toast.LENGTH_SHORT).show();
                    showWebView(fl.toString());
                    return;
                case R.id.imgitem:
                    String floc=(String) v.getTag();
                    Toast.makeText(context,floc.toString(),Toast.LENGTH_SHORT).show();
                    showView(floc.toString());
                    return;
            }
        }
    };

    public View getView(int position, View convertView, ViewGroup parent) {
          LayoutInflater inflater= context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);


        final Foods foods=myArray.get(position);

        final TextView txtdisplay = (TextView) convertView.findViewById(R.id.txtitem);
        txtdisplay.setTag(foods.getFoodLink());
        txtdisplay.setText(foods.toString());
        txtdisplay.setOnClickListener(foodOnclick);
        checkBox=convertView.findViewById(R.id.chkitem);
        checkBox.setChecked(foods.isChecked());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    foods.setChecked(true);
                }else{
                    foods.setChecked(false);
                }
            }
        });
         txtdisplay.setText(foods.toString());


        final ImageView imgitem=(ImageView) convertView.findViewById(R.id.imgitem);
        Drawable drawable =   AppCompatResources.getDrawable(context, foods.getImgFood());
        imgitem.setImageDrawable(drawable);
        imgitem.setTag(foods.getFoodLocaltion());
        imgitem.setOnClickListener(foodOnclick);

    return convertView;
}
    private void showWebView(String v) {
        Intent intent=new Intent(context, WebView_MonAn.class);
        intent.putExtra("foodlink",v);
        context.startActivity(intent);
    }
    private void showView(String v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(v));
        intent.setPackage("com.android.chrome");
        if (intent.resolveActivity(context.getPackageManager())!=null)

            context.startActivity(intent);
    }
}
