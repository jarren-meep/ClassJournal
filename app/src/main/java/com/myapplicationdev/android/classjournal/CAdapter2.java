package com.myapplicationdev.android.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CAdapter2 extends ArrayAdapter {
    private ArrayList<module> module;
    private Context context;
    private TextView tvModuleName, tvModuleCode;

    public CAdapter2(Context context, int resource, ArrayList<module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvModuleName = rowView.findViewById(R.id.textViewName);
        tvModuleCode = rowView.findViewById(R.id.textViewCode);

        module currentModules = module.get(position);

        tvModuleName.setText(currentModules.getName());
        tvModuleCode.setText(currentModules.getCode());
        return rowView;
    }
}