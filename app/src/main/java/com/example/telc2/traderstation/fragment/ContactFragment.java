package com.example.telc2.traderstation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.AdapterContact;
import com.example.telc2.traderstation.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 11/15/2017.
 */

public class ContactFragment extends Fragment{

    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterContact adapterContact;

    public ContactFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_contact, container, false);

        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerContact);
        //dataList = new ArrayList<HashMap<String,String>>();
        adapterContact = new AdapterContact(contactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterContact);
        loadDataDummy();

        return v;
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Contact contact = new Contact("1","Profile Name","","lorem ipsum");
            contactList.add(contact);
            adapterContact.notifyDataSetChanged();
        }
    }

    public void filter(String text){
        List<Contact> temp = new ArrayList();
        for(Contact d: contactList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getContactName().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        adapterContact.updateList(temp);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.search).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}
