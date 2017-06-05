package com.fancymonk.fancymonk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Menu> mMenu;
    private Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        mMenu = new ArrayList<Menu>();
        for(int i=1; i<10; i++){

            Menu menuItem = new Menu("Menu item "+i, "Menu description "+i, i*10.0,false);
            mMenu.add(menuItem);
        }
    }
}
