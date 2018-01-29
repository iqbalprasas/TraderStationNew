package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 1/29/2018.
 */

public class ShopAdapter extends BaseAdapter {

    Context context;
    boolean discount[];
    boolean ls[];
    LayoutInflater inflter;
    LinearLayout containerDiscount;
    LinearLayout containerLimited;

    public ShopAdapter(Context applicationContext, boolean[] discount, boolean[] ls) {
        this.context = applicationContext;
        this.discount = discount;
        this.ls = ls;
        inflter = (LayoutInflater.from(applicationContext));
    }

    public boolean getDisc(int i){
        return discount[i];
    }

    public boolean getLs(int i){
        return ls[i];
    }

    @Override
    public int getCount() {
        return discount.length;
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
        view = inflter.inflate(R.layout.list_item_shop, null);
        containerDiscount = (LinearLayout)view.findViewById(R.id.container_discount_shop);
        containerLimited = (LinearLayout)view.findViewById(R.id.img_ls_shop);
        if(getDisc(i)==false){
            containerDiscount.setVisibility(View.GONE);
        }

        if (getLs(i)==false){
            containerLimited.setVisibility(View.GONE);
        }
        return view;
    }
}
