package com.example.david.dontouch.Activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.example.david.dontouch.Adapter.ViewPagerAdapter;
import com.example.david.dontouch.Fragment.HomeFragment;
import com.example.david.dontouch.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    HomeFragment homeFragment;
    MenuItem prevMenuItem;
    BottomNavigationView navigation;

    private ViewPager.OnPageChangeListener mOnViewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (prevMenuItem != null) {
                prevMenuItem.setChecked(false);
            }
            else
            {
                navigation.getMenu().getItem(0).setChecked(false);
            }
            Log.d("page", "onPageSelected: "+position);
            navigation.getMenu().getItem(position).setChecked(true);
            prevMenuItem = navigation.getMenu().getItem(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_journal:
                    mTextMessage.setText(R.string.title_journal);
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_assessment:
                    mTextMessage.setText(R.string.title_assessment);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    viewPager.setCurrentItem(0);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(mOnViewPageChangeListener);
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        adapter.add(homeFragment);
        viewPager.setAdapter(adapter);
    }

}
