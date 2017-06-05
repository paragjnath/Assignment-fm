package com.fancymonk.fancymonk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
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
        return null;
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

        public ViewHolder(View view){
            super(view);
            mView = view;
            mMenuName = (TextView) mView.findViewById(R.id.tvMenuName);
            mMenuDescription = (TextView) mView.findViewById(R.id.tvMenuDescription);
            mMenuItemPrice = (TextView) mView.findViewWithTag(R.id.tvMenuItemPrice);

        }
    }


}
