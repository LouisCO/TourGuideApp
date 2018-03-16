package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Lenovo on 13/03/2018.
 * Provides {@link android.app.Fragment} for a view pager
 */

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    private String[] category;

    CategoryPagerAdapter(Context context, FragmentManager fm) {
        super((fm));
        this.category=context.getResources().getStringArray(R.array.categories);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(this.category[position]);
    }

    @Override
    public int getCount() {
        return this.category.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.category[position];
    }
}
