package com.fancymonk.fancymonk.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.fancymonk.fancymonk.OrderActivity;
import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.adapter.MenuRecyclerViewAdapter;
import com.fancymonk.fancymonk.model.Menu;

import java.util.ArrayList;
import java.util.List;

import static com.fancymonk.fancymonk.R.id.btnConfirm;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Menu> mMenu;
    private RelativeLayout btnConfirm;
    private Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //change the color of the upArrow to white
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null)
        {
            getSupportActionBar().setTitle(bundle.getString("name"));
        }

        btnConfirm = (RelativeLayout) findViewById(R.id.btnConfirm);

        mMenu = new ArrayList<Menu>();
        for(int i=1; i<10; i++){

            Menu menuItem = new Menu("Menu item "+i, "Menu description "+i, i*10.0,false);
            mMenu.add(menuItem);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.menuRecyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MenuRecyclerViewAdapter(mMenu);

        mRecyclerView.setAdapter(mAdapter);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Menu> menu = ((MenuRecyclerViewAdapter) mAdapter).getMenuList();
                ArrayList<Menu> checkedMenu = new ArrayList<Menu>();

                for(int i = 0; i<menu.size(); i++){

                    Menu menuItem = menu.get(i);
                    if (menuItem.isSelected()){
                        checkedMenu.add(menuItem);
                    }
                }

                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                intent.putParcelableArrayListExtra("selectedMenu",checkedMenu);
                startActivity(intent);

            }
        });
    }
}
