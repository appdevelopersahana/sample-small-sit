package com.example.user.searchablerecyclerview.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.user.searchablerecyclerview.Adapters.ApplianceAdapter;
import com.example.user.searchablerecyclerview.NetCalls.MakeNetCalls;
import com.example.user.searchablerecyclerview.R;
import com.example.user.searchablerecyclerview.models.modified.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApplianceActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, MakeNetCalls.CallBack, SearchView.OnQueryTextListener, ApplianceAdapter.LayoutClickListener, View.OnFocusChangeListener {
    @BindView(R.id.applianceRecyclerView)
    RecyclerView mApplianceRecyclerView;
    @BindView(R.id.swipeToRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    private RecyclerView.LayoutManager mLayoutManager;
    private ApplianceAdapter mApplianceAdapter;
    private Timer mTimer;
    private Runnable mRunnable;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mApplianceRecyclerView.setLayoutManager(mLayoutManager);
        mApplianceRecyclerView.setHasFixedSize(true);
        final Handler handler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                MakeNetCalls.getInstance().getProductValues(ApplianceActivity.this,
                        getIntent().getStringExtra("search input"));
                mSwipeRefreshLayout.setOnRefreshListener(ApplianceActivity.this);
            }
        };

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(mRunnable);
            }
        }, 1000, 1000);
        mApplianceAdapter = new ApplianceAdapter();
        mApplianceRecyclerView.setAdapter(mApplianceAdapter);
        mApplianceAdapter.setLayoutClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchview, menu);
        MenuItem menuItem = menu.findItem(R.id.searchProducts);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextFocusChangeListener(this);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    protected void onResume() {

        super.onResume();

    }

    @Override
    public void onRefresh() {
        if (MakeNetCalls.getInstance() != null) {
            MakeNetCalls.getInstance().getProductValues(ApplianceActivity.this,
                    getIntent().getStringExtra("search input"));
        }
    }

    @Override
    public void onSuccess(final List<Object> sellersData) {
        this.runOnUiThread(new Runnable() {
            public void run() {
                if (mApplianceAdapter != null)
                    mApplianceAdapter.setData(sellersData);
                mSwipeRefreshLayout.setRefreshing(false);
                mProgressBar.bringToFront();
            }
        });
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                mTimer.cancel();
            }
        };

    }

    @Override
    public void onClick(Object applianceData) {
        if (applianceData instanceof SonyTv) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((SonyTv) applianceData).applianceName)
                    .putExtra("imageURL", ((SonyTv) applianceData).imageUrl)
                    .putExtra("amazon", ((SonyTv) applianceData).amazon)
                    .putExtra("walMart", ((SonyTv) applianceData).walMart)
                    .putExtra("target", ((SonyTv) applianceData).target)
                    .putExtra("rating", ((SonyTv) applianceData).rating)
                    .putExtra("model",((SonyTv) applianceData).modelNo));
        } else if (applianceData instanceof LgTv) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((LgTv) applianceData).applianceName)
                    .putExtra("imageURL", ((LgTv) applianceData).imageUrl)
                    .putExtra("amazon", ((LgTv) applianceData).amazon)
                    .putExtra("walMart", ((LgTv) applianceData).walMart)
                    .putExtra("target", ((LgTv) applianceData).target)
                    .putExtra("rating", ((LgTv) applianceData).rating)
                    .putExtra("model",((LgTv) applianceData).modelNo));
        } else if (applianceData instanceof LgMobiles) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((LgMobiles) applianceData).applianceName)
                    .putExtra("imageURL", ((LgMobiles) applianceData).imageUrl)
                    .putExtra("amazon", ((LgMobiles) applianceData).amazon)
                    .putExtra("walMart", ((LgMobiles) applianceData).walMart)
                    .putExtra("target", ((LgMobiles) applianceData).target)
                    .putExtra("rating", ((LgMobiles) applianceData).rating)
                    .putExtra("model",((LgMobiles) applianceData).modelNo));
        } else if (applianceData instanceof SamsungMobiles) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((SamsungMobiles) applianceData).applianceName)
                    .putExtra("imageURL", ((SamsungMobiles) applianceData).imageUrl)
                    .putExtra("amazon", ((SamsungMobiles) applianceData).amazon)
                    .putExtra("walMart", ((SamsungMobiles) applianceData).walMart)
                    .putExtra("target", ((SamsungMobiles) applianceData).target)
                    .putExtra("rating", ((SamsungMobiles) applianceData).rating)
                    .putExtra("model",((SamsungMobiles) applianceData).modelNo));
        } else if (applianceData instanceof SamsungTv) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((SamsungTv) applianceData).applianceName)
                    .putExtra("imageURL", ((SamsungTv) applianceData).imageUrl)
                    .putExtra("amazon", ((SamsungTv) applianceData).amazon)
                    .putExtra("walMart", ((SamsungTv) applianceData).walMart)
                    .putExtra("target", ((SamsungTv) applianceData).target)
                    .putExtra("rating", ((SamsungTv) applianceData).rating)
                    .putExtra("model",((SamsungTv) applianceData).modelNo));
        } else if (applianceData instanceof SamsungAc) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((SamsungAc) applianceData).applianceName)
                    .putExtra("imageURL", ((SamsungAc) applianceData).imageUrl)
                    .putExtra("amazon", ((SamsungAc) applianceData).amazon)
                    .putExtra("walMart", ((SamsungAc) applianceData).walMart)
                    .putExtra("target", ((SamsungAc) applianceData).target)
                    .putExtra("rating", ((SamsungAc) applianceData).rating)
                    .putExtra("model",((SamsungAc) applianceData).modelNo));
        } else if (applianceData instanceof LgAc) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((LgAc) applianceData).applianceName)
                    .putExtra("imageURL", ((LgAc) applianceData).imageUrl)
                    .putExtra("amazon", ((LgAc) applianceData).amazon)
                    .putExtra("walMart", ((LgAc) applianceData).walMart)
                    .putExtra("target", ((LgAc) applianceData).target)
                    .putExtra("rating", ((LgAc) applianceData).rating)
                    .putExtra("model",((LgAc) applianceData).modelNo));
        } else if (applianceData instanceof SonyMobiles) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((SonyMobiles) applianceData).applianceName)
                    .putExtra("imageURL", ((SonyMobiles) applianceData).imageUrl)
                    .putExtra("amazon", ((SonyMobiles) applianceData).amazon)
                    .putExtra("walMart", ((SonyMobiles) applianceData).walMart)
                    .putExtra("target", ((SonyMobiles) applianceData).target)
                    .putExtra("rating", ((SonyMobiles) applianceData).rating)
                    .putExtra("model",((SonyMobiles) applianceData).modelNo));
        } else if (applianceData instanceof PanasonicAC) {
            startActivity(new Intent(getApplicationContext(), PriceComparisionActivity.class)
                    .putExtra("applainceName", ((PanasonicAC) applianceData).applianceName)
                    .putExtra("imageURL", ((PanasonicAC) applianceData).imageUrl)
                    .putExtra("amazon", ((PanasonicAC) applianceData).amazon)
                    .putExtra("walMart", ((PanasonicAC) applianceData).walMart)
                    .putExtra("target", ((PanasonicAC) applianceData).target)
                    .putExtra("rating", ((PanasonicAC) applianceData).rating)
                    .putExtra("model",((PanasonicAC) applianceData).modelNo));
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
