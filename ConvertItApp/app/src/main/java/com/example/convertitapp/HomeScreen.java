package com.example.convertitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new
                ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int numOfTabs;

        public ViewPagerAdapter (FragmentManager fm, int numOfTabs) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.numOfTabs = numOfTabs;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_1();
                case 1:
                    return new Fragment_2();
                case 2:
                    return new Fragment_3();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return getString(R.string.tab_text_1);
                case 1:
                    return getString(R.string.tab_text_2);
                case 2:
                    return getString(R.string.tab_text_3);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numOfTabs;
        }
    }
}