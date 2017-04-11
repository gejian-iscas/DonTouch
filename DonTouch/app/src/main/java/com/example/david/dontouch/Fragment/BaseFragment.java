package com.example.david.dontouch.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by david on 2017/3/23.
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected View mRootView;
    private Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        init();
        return mRootView;
    }


    protected abstract void init();


    protected abstract int getLayoutId();


    public View findViewById(int id) {
        if (getContentView() != null) {
            return getContentView().findViewById(id);
        } else {
            return null;
        }
    }


    protected View getContentView() {
        return mRootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
