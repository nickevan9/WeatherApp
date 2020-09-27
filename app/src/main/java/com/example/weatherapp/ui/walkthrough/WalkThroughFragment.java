package com.example.weatherapp.ui.walkthrough;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.ui.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

public class WalkThroughFragment extends BaseFragment {


    public static WalkThroughFragment newInstance() {
        return new WalkThroughFragment();
    }

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Button mBtnGetStarted;

    private WalkThroughPagerAdapter mAdapter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_walk_through;
    }

    @Override
    protected void dataCreate() {

    }

    @Override
    protected void initView() {
        mTabLayout = requireView().findViewById(R.id.tabDots);
        mViewPager = requireView().findViewById(R.id.vPWalkThrough);
        mBtnGetStarted = requireView().findViewById(R.id.btnGetStarted);
        mTabLayout.setupWithViewPager(mViewPager,true);

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        mAdapter = new WalkThroughPagerAdapter(getChildFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)(new TabLayout.TabLayoutOnPageChangeListener(this.mTabLayout)));

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
            FragmentUtils.findNavController(this).navigate(R.id.action_walkThroughFragment_to_homeFragment);
            DataProccessor.setFirstTimeLaunch(false);
        });
    }



}