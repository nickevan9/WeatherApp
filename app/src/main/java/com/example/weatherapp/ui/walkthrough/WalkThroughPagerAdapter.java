package com.example.weatherapp.ui.walkthrough;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class WalkThroughPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;
    public WalkThroughPagerAdapter(FragmentManager fm,int tabCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
               return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            default:
                return ThirdFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
