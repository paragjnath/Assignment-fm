package com.fancymonk.fancymonk.adapter;

import android.support.v7.widget.RecyclerView;

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




}
