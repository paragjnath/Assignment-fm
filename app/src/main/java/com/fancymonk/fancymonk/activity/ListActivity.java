package com.fancymonk.fancymonk.activity;

import android.graphics.Movie;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.adapter.ClientRecyclerViewAdapter;
import com.fancymonk.fancymonk.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private List<Client> clientList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ClientRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //change the color of the upArrow to white
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new ClientRecyclerViewAdapter(clientList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareClientData();
    }

    private void prepareClientData(){

        Client client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Tea Rexx","Hsr","","Casual","Italian");
        clientList.add(client);

        client = new Client("O My Hunger","Koramangala","","Casual","Sea Food");
        clientList.add(client);

        client = new Client("Coffee On Canvas","Koramangala","Open Roof","","Continental");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        client = new Client("Cafenation","Koramangala","","Casual","Italian");
        clientList.add(client);

        mAdapter.notifyDataSetChanged();


    }
}
