package com.fancymonk.fancymonk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.activity.MenuActivity;
import com.fancymonk.fancymonk.model.Client;

import java.util.List;



/**
 * Created by Pavilion on 03-06-2017.
 */

public class ClientRecyclerViewAdapter extends RecyclerView.Adapter<ClientRecyclerViewAdapter.ViewHolder>{

    private List<Client> mClientList;
    Context ctxt;
    String name;


    class ViewHolder extends RecyclerView.ViewHolder{

        View mView;
        TextView mName;
        TextView mLocation;
        TextView mTagOne;
        TextView mTagTwo;
        ImageView mImageView;

        public ViewHolder(View view){
            super(view);
            mView = view;
            mName = (TextView) mView.findViewById(R.id.name);
            mLocation = (TextView) mView.findViewById(R.id.location);
            mTagOne = (TextView) mView.findViewById(R.id.tagOne);
            mTagTwo = (TextView) mView.findViewById(R.id.tagTwo);
            mImageView = (ImageView) mView.findViewById(R.id.imageView);
        }
    }


    public ClientRecyclerViewAdapter(List<Client> clientList, Context context) {
        this.mClientList = clientList;
        this.ctxt =context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_items, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Client client = mClientList.get(position);
        holder.mName.setText(client.getName());
        holder.mLocation.setText(client.getLocation());
        holder.mTagOne.setText(client.getmTagOne());
        holder.mTagTwo.setText(client.getmTagTwo());
        name = client.getName();


    }

    @Override
    public int getItemCount() {
        return mClientList.size();
    }
}
