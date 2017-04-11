package com.example.david.dontouch.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.dontouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JournalFragment extends LazyLoadFragment {


    public JournalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void lazyLoad() {

    }
}
