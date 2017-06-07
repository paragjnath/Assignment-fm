package com.fancymonk.fancymonk.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fancymonk.fancymonk.CaptureSignatureView;
import com.fancymonk.fancymonk.R;

import static com.fancymonk.fancymonk.R.id.btnSubmit;

public class ConfirmActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CaptureSignatureView mSig;
    private int mItems;
    private double mAmount;
    private TextView tvNoOfItems;
    private TextView tvTotalPrice;
    private RelativeLayout btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            mItems = bundle.getInt("items");
            mAmount = bundle.getDouble("amount");
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbarConfirm);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.grey));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Confirm Receive");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //change the color of the upArrow to white
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        FrameLayout mContent = (FrameLayout) findViewById(R.id.tvSign);
        mSig = new CaptureSignatureView(this, null);
        mContent.addView(mSig, ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);

        TextView clear = (TextView) findViewById(R.id.textViewClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSig.ClearCanvas();

            }
        });

        tvNoOfItems = (TextView) findViewById(R.id.tvNoOfItems);
        tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);
        btnSubmit = (RelativeLayout) findViewById(R.id.btnSubmit);

        tvNoOfItems.setText(mItems+"");
        tvTotalPrice.setText(mAmount+"");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ConfirmActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });



    }
}
