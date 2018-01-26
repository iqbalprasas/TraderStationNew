package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.ReviewBrokerActivity;
import com.example.telc2.traderstation.model.Broker;
import java.util.List;

/**
 * Created by iqbal on 12/15/2017.
 */

public class BrokerAdapter extends BaseAdapter {

    Context context;
    int images[];
    LayoutInflater inflter;
    LinearLayout expandButton;

    public BrokerAdapter(Context applicationContext, int[] images) {
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
        view = inflter.inflate(R.layout.list_item_broker, null);
//        LinearLayout layout = (LinearLayout) view.findViewById(R.id.img_cover_album);
//        layout.setBackgroundResource(images[i]);
        expandButton = (LinearLayout) view.findViewById(R.id.layout_expand_broker);
        expandButton.setVisibility(View.GONE);
        Button btnWebsite = (Button) view.findViewById(R.id.btn_web_broker);
        Button btnReview = (Button) view.findViewById(R.id.btn_review_broker);
        ImageButton btnClose = (ImageButton) view.findViewById(R.id.btn_close_expand_broker);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Website",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Review",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.anim_close);
                expandButton.setAnimation(slideUp);
                expandButton.setVisibility(View.GONE);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
