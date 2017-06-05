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
 * Created by Pavilion on 05-06-2017.
 */

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder>{

    private List<Menu> mMenuList;

    public MenuRecyclerViewAdapter(List<Menu> menuList){
        mMenuList = menuList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_items,parent,false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View mView;
        TextView mMenuName;
        TextView mMenuDescription;
        TextView mMenuItemPrice;
        CheckBox mCheckBox;

        public ViewHolder(View view){
            super(view);
            mView = view;
            mMenuName = (TextView) mView.findViewById(R.id.tvMenuName);
            mMenuDescription = (TextView) mView.findViewById(R.id.tvMenuDescription);
            mMenuItemPrice = (TextView) mView.findViewWithTag(R.id.tvMenuItemPrice);
            mCheckBox = (CheckBox) mView.findViewById(R.id.chkSelected);

        }
    }


}
