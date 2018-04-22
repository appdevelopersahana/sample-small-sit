package com.example.user.searchablerecyclerview.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.searchablerecyclerview.R;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PriceComparisionActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.applianceNameTextView)
    TextView mApplianceNameTextView;
    @BindView(R.id.price1TextView)
    TextView mPrice1TextView;
    @BindView(R.id.productImageView)
    ImageView mProductImageView;
    //@BindView(R.id.ratingBar2)
    //SimpleRatingBar mSimpleRatingBar2;
    // @BindView(R.id.ratingBar3)
    // SimpleRatingBar mSimpleRatingBar3;
    @BindView(R.id.ratingBar1)
    SimpleRatingBar mSimpleRatingBar1;
    @BindView(R.id.price2TextView)
    TextView mPrice2TextView;
    @BindView(R.id.price3TextView)
    TextView mPrice3TextView;
    @BindView(R.id.seller3TextView)
    TextView mSeller3TextView;
    @BindView(R.id.targetButton)
    Button mTargetButton;
    @BindView(R.id.walMartButton)
    Button mWalMartButton;
    @BindView(R.id.amazonButton)
    Button mAmazonButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_comparision);
        ButterKnife.bind(this);
        mApplianceNameTextView.setText(getIntent().getExtras().getString("applainceName"));
        Glide.with(mProductImageView.getContext()).load(getIntent().getExtras().getString("imageURL")).into(mProductImageView);
        mPrice1TextView.setText(getIntent().getExtras().getString("amazon"));
        mPrice2TextView.setText(getIntent().getExtras().getString("walMart"));
        mSimpleRatingBar1.setRating(getIntent().getExtras().getFloat("rating"));
        mPrice3TextView.setText(getIntent().getExtras().getString("target"));
        mAmazonButton.setOnClickListener(this);
        mWalMartButton.setOnClickListener(this);
        mTargetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Uri uri=Uri.parse("https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=");
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords="+getIntent().getStringExtra("model"))));
    }
}
