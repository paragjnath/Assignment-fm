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

    private int pos;

    public MenuRecyclerViewAdapter(List<Menu> menuList){
        mMenuList = menuList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_items,null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        pos = position;

        holder.mMenuName.setText(mMenuList.get(position).getName());

        holder.mMenuDescription.setText(mMenuList.get(position).getDescription());

        holder.mMenuItemPrice.setText(mMenuList.get(position).getPrice().toString());

       holder.mCheckBox.setTag(mMenuList.get(position));

       holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckBox checkBox = (CheckBox) view;

                Menu menuItem = (Menu) checkBox.getTag();
                menuItem.setSelected(checkBox.isChecked());
                mMenuList.get(pos).setSelected(checkBox.isChecked());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public List<Menu> getMenuList(){
        return mMenuList;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public   TextView mMenuName;
        public   TextView mMenuDescription;
        public   TextView mMenuItemPrice;
        public   CheckBox mCheckBox;

        public ViewHolder(View view){
            super(view);
            mMenuName = (TextView) view.findViewById(R.id.tvMenuName);
            mMenuDescription = (TextView) view.findViewById(R.id.tvMenuDescription);
            mMenuItemPrice = (TextView) view.findViewById(R.id.tvItemPrice);
            mCheckBox = (CheckBox) view.findViewById(R.id.chkSelected);

        }
    }


}
