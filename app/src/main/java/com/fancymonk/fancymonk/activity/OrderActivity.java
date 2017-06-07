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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fancymonk.fancymonk.R;
import com.fancymonk.fancymonk.activity.ConfirmActivity;
import com.fancymonk.fancymonk.adapter.MenuRecyclerViewAdapter;
import com.fancymonk.fancymonk.adapter.OrderRecyclerViewAdapter;
import com.fancymonk.fancymonk.model.Menu;

import java.util.ArrayList;
import java.util.List;

import static com.fancymonk.fancymonk.R.id.btnDispatch;

public class OrderActivity extends AppCompatActivity {

    private double mTotalPrice;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Menu> selectedItems ;
    private Toolbar mToolbar;
    private RelativeLayout btnDispatch;
    private TextView mOrderAmount;
    private TextView mOrderNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mOrderAmount = (TextView) findViewById(R.id.tvOrderAmount);
        mOrderNumber = (TextView) findViewById(R.id.tvOrderNumber);

        mToolbar = (Toolbar) findViewById(R.id.toolbarOrder);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Confirm Order");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //change the color of the upArrow to white
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mTotalPrice = 0;

        selectedItems = this.getIntent().getParcelableArrayListExtra("selectedMenu");

        for (int i = 0; i < selectedItems.size(); i++) {

            mTotalPrice = mTotalPrice + selectedItems.get(i).getPrice();

            Log.v("orderActivity", "SELECTED " + selectedItems.get(i).getName());

        }

        Toast.makeText(getApplicationContext(),"Total price is "+mTotalPrice,Toast.LENGTH_SHORT).show();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewOrder);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new OrderRecyclerViewAdapter(selectedItems);

        mRecyclerView.setAdapter(mAdapter);

        btnDispatch = (RelativeLayout) findViewById(R.id.btnDispatch);
        btnDispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);
                startActivity(intent);

            }
        });

        mOrderNumber.setText(selectedItems.size()+"");
        mOrderAmount.setText(mTotalPrice+"");
    }
}
