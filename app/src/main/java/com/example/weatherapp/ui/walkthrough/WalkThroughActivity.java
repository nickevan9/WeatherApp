package com.example.weatherapp.ui.walkthrough;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.widget.Button;

import com.example.weatherapp.R;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.loadingdata.LoadingDataActivity;
import com.google.android.material.tabs.TabLayout;

public class WalkThroughActivity extends BaseActivity {


    public static WalkThroughActivity newInstance() {
        return new WalkThroughActivity();
    }

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Button mBtnGetStarted;

    private WalkThroughPagerAdapter mAdapter;

    @Override
    protected int layoutRes() {
        return R.layout.activity_walk_through;
    }

    @Override
    protected void dataCreate() {

    }

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.tabDots);
        mViewPager = findViewById(R.id.vPWalkThrough);
        mBtnGetStarted = findViewById(R.id.btnGetStarted);
        mTabLayout.setupWithViewPager(mViewPager,true);

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        mAdapter = new WalkThroughPagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBtnGetStarted.setOnClickListener(view -> {

            Intent intent = new Intent(this, LoadingDataActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}