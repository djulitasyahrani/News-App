package com.example.newsss.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsss.Fragment.EntertainmentFragment;
import com.example.newsss.Fragment.HealthFragment;
import com.example.newsss.Fragment.HomeFragment;
import com.example.newsss.Fragment.ScieneFragment;
import com.example.newsss.Fragment.SportsFragment;
import com.example.newsss.Fragment.TechFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();

            case 2:
                return new HealthFragment();

            case 3:
                return new ScieneFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
