package com.example.telc2.traderstation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.AlbumSelectedActivity;
import com.example.telc2.traderstation.adapter.AlbumAdapter;
import com.example.telc2.traderstation.helper.ExpandableHeightGridView;

/**
 * Created by iqbal on 12/29/2017.
 */

public class AlbumFragment extends Fragment {

    ExpandableHeightGridView gridAlbum;
    int images[] = {R.drawable.seminar_web, R.drawable.seminar_web, R.drawable.seminar_web, R.drawable.seminar_web};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflating the layout for this fragment **/
        View v = inflater.inflate(R.layout.fragment_album_gallery, null);

        //gridAlbum = (GridView) v.findViewById(R.id.gridview_gallery); // init GridView
        gridAlbum = (ExpandableHeightGridView) v.findViewById(R.id.gridview_gallery);
        gridAlbum.setExpanded(true);
        // Create an object of CustomAdapter and set Adapter to GirdView
        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity().getApplicationContext(), images);
        gridAlbum.setAdapter(albumAdapter);
        // implement setOnItemClickListener event on GridView
        gridAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(getContext(), AlbumSelectedActivity.class);
                intent.putExtra(
                        "image", images[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });

        return v;
    }
}
