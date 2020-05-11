package com.android.kimnabin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyIconAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<MyIcon> myIcons;
    LayoutInflater inflater;

    public MyIconAdapter(Context context, ArrayList<MyIcon> myIcons, int layout)
    {
        this.context = context;
        this.myIcons = myIcons;
        this.layout = layout;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return myIcons.size();
    }

    @Override
    public Object getItem(int position) {
        return myIcons.get(position).getIconName();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.iconImage);
        img.setImageResource(myIcons.get(position).getIconImage());

        TextView txt = convertView.findViewById(R.id.iconName);
        txt.setText(myIcons.get(position).getIconName());

        convertView.setTag(myIcons.get(position).getIconTag());

        return convertView;

    }
}
