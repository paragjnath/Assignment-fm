package com.fancymonk.fancymonk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.model.Menu;

import java.util.List;

/**
 * Created by Tan on 6/6/2017.
 */

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder>{

    private List<Menu> mMenuList;


    public OrderRecyclerViewAdapter(List<Menu> menuList){
        mMenuList = menuList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_menu_items,null);

        OrderRecyclerViewAdapter.ViewHolder viewHolder = new OrderRecyclerViewAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrderRecyclerViewAdapter.ViewHolder holder, int position) {


        holder.mMenuName.setText(mMenuList.get(position).getName());

        holder.mMenuDescription.setText(mMenuList.get(position).getDescription());

        holder.mMenuItemPrice.setText(mMenuList.get(position).getPrice().toString());


    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public List<Menu> getMenuList(){
        return mMenuList;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mMenuName;
        public   TextView mMenuDescription;
        public   TextView mMenuItemPrice;

        public ViewHolder(View view){
            super(view);
            mMenuName = (TextView) view.findViewById(R.id.tvOrderMenuName);
            mMenuDescription = (TextView) view.findViewById(R.id.tvOrderMenuDescription);
            mMenuItemPrice = (TextView) view.findViewById(R.id.tvOrderItemPrice);

        }
    }



}