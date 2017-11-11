package com.example.telc2.traderstation.adapter;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.DataDrawer;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iqbal on 11/7/2017.
 */

public class DrawerItemAdapter extends ArrayAdapter<DataDrawer>{
    Context mContext;
    int layoutResourceId;
    DataDrawer data[] = null;

    public DrawerItemAdapter(Context mContext, int layoutResourceId, DataDrawer[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        DataDrawer folder = data[position];

        //imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
