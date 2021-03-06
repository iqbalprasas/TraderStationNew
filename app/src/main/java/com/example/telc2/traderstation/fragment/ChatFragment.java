package com.example.telc2.traderstation.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.AdapterChat;
import com.example.telc2.traderstation.model.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 11/15/2017.
 */

public class ChatFragment extends Fragment{

    private List<Chat> chatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterChat adapterChat;
    private Toolbar toolbar;
    private ImageButton searctTt;

    public ChatFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_chat, container, false);

        setHasOptionsMenu(true);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_menu);
        searctTt = (ImageButton) toolbar.findViewById(R.id.btn_search_tt);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New chat", Snackbar.LENGTH_LONG)
                        .setAction("Select", null).show();
            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerChat);
        //dataList = new ArrayList<HashMap<String,String>>();
        adapterChat = new AdapterChat(chatList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterChat);
        loadDataDummy();

        return v;
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Chat chat = new Chat("1","","Profile Name","lorem ipsum","999");
            chatList.add(chat);
            adapterChat.notifyDataSetChanged();
        }
    }

    public void filter(String text){
        List<Chat> temp = new ArrayList();
        for(Chat d: chatList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getProfileName().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        adapterChat.updateList(temp);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.search).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setListToTop(){
        //((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPosition(0);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                recyclerView.scrollToPosition(chatList.size()-1);
//            }
//        }, 200);
    }
}
