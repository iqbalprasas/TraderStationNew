package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.CommentAdapter;
import com.example.telc2.traderstation.helper.NonScrollRecyclerView;
import com.example.telc2.traderstation.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 1/19/2018.
 */

public class TimelineSelectedActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton back;
    private List<Comment> commentList = new ArrayList<>();
    private NonScrollRecyclerView recyclerView;
    private CommentAdapter commentAdapter;
    private String status;
    private ImageView imgPost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar_timeline_selected);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_timeline_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgPost = (ImageView) findViewById(R.id.img_timeline_selected);
        status = getIntent().getStringExtra("isImgExist");
        if(!status.equals("News")){
            imgPost.setVisibility(View.GONE);
        }

        recyclerView = (NonScrollRecyclerView) findViewById(R.id.nonscrolllistComment);
        //dataList = new ArrayList<HashMap<String,String>>();
        commentAdapter = new CommentAdapter(commentList);
        NonScrollRecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TimelineSelectedActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(commentAdapter);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<3;i++){
            Comment comment = new Comment("Profile Name "+String.valueOf(i));
            commentList.add(comment);
            commentAdapter.notifyDataSetChanged();
        }
    }
}
