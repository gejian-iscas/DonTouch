package com.example.david.dontouch.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.dontouch.Adapter.ViewPagerAdapter;
import com.example.david.dontouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends LazyLoadFragment {

    private ViewPager viewPager;
    private JournalFragment journalFragment;

    public HomeFragment() {
        // Required empty public constructor
    }

    private ViewPager.OnPageChangeListener mOnViewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //viewPager = (ViewPager) findViewById(R.id.vp_home);
        //viewPager.addOnPageChangeListener(mOnViewPageChangeListener);
        //setupViewPager(viewPager);
        return view;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void lazyLoad() {

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        journalFragment = new JournalFragment();
        adapter.add(journalFragment);
        viewPager.setAdapter(adapter);
    }
}
