package com.fancymonk.fancymonk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fancymonk.fancymonk.model.Menu;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private double mTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mTotalPrice = 0;

        ArrayList<Menu> selectedItems = this.getIntent().getParcelableArrayListExtra("selectedMenu");

        for (int i = 0; i < selectedItems.size(); i++) {

            mTotalPrice = mTotalPrice + selectedItems.get(i).getPrice();

            Log.v("orderActivity", "SELECTED " + selectedItems.get(i).getName());
        }

        Toast.makeText(getApplicationContext(),"Total price is "+mTotalPrice,Toast.LENGTH_SHORT).show();
    }
}
