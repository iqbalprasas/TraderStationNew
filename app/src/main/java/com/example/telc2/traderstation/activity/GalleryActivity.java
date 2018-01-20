package com.example.telc2.traderstation.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.fragment.AlbumFragment;
import com.example.telc2.traderstation.fragment.LatestFragment;

/**
 * Created by iqbal on 12/29/2017.
 */

public class GalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton back;
    private Button btnLates, btnAlbum;
    private int pos = 0;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LatestFragment latest;
    AlbumFragment album;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar_gallery);

        btnLates = (Button) findViewById(R.id.btn_latest_gallery);
        btnAlbum = (Button) findViewById(R.id.btn_album_gallery);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_gallery);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        latest = new LatestFragment();
        album = new AlbumFragment();
        fragmentTransaction.add(R.id.fragment_layout, latest, "latest");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos==0){
                    pos = 1;
                    btnLates.setBackgroundResource(R.drawable.unclick);
                    btnLates.setTextColor(Color.parseColor("#4AB240"));
                    btnAlbum.setBackgroundResource(R.drawable.click);
                    btnAlbum.setTextColor(Color.WHITE);
                    album = new AlbumFragment();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_layout, album);
                    fragmentTransaction.commit();
                }
            }
        });

        btnLates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos==1){
                    pos = 0;
                    btnLates.setBackgroundResource(R.drawable.click);
                    btnLates.setTextColor(Color.WHITE);
                    btnAlbum.setBackgroundResource(R.drawable.unclick);
                    btnAlbum.setTextColor(Color.parseColor("#4AB240"));
                    latest = new LatestFragment();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_layout, latest);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
