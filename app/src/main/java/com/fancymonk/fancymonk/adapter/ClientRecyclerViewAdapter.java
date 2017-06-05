package com.fancymonk.fancymonk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.model.Client;

import java.util.List;



/**
 * Created by Pavilion on 03-06-2017.
 */

public class ClientRecyclerViewAdapter extends RecyclerView.Adapter<ClientRecyclerViewAdapter.ViewHolder>{

    private List<Client> mClientList;


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
            mTagOne = (TextView) mView.findViewWithTag(R.id.tagOne);
            mTagTwo = (TextView) mView.findViewWithTag(R.id.tagTwo);
            mImageView = (ImageView) mView.findViewById(R.id.imageView);
        }
    }


    public ClientRecyclerViewAdapter(List<Client> clientList) {
        this.mClientList = clientList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_items, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Client client = mClientList.get(position);
        holder.mName.setText(client.getName());
        holder.mLocation.setText(client.getLocation());
        //holder.mTagOne.setText(client.getmTagOne());
        //holder.mTagTwo.setText(client.getmTagTwo());


    }

    @Override
    public int getItemCount() {
        return mClientList.size();
    }
}
