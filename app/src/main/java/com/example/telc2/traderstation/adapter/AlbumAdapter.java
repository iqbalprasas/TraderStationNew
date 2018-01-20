package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 12/29/2017.
 */

public class AlbumAdapter extends BaseAdapter {

    Context context;
    int images[];
    LayoutInflater inflter;

    public AlbumAdapter(Context applicationContext, int[] images) {
        this.context = applicationContext;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_item_album, null);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.img_cover_album);
        layout.setBackgroundResource(images[i]);
        return view;
    }

}
