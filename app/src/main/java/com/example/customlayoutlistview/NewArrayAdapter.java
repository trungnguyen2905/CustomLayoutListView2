package com.example.customlayoutlistview;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class NewArrayAdapter extends ArrayAdapter<Employee> {


    public NewArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
