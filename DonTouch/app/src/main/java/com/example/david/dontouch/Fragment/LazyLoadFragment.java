package com.example.david.dontouch.Fragment;

/**
 * Created by david on 2017/3/23.
 */

public abstract class LazyLoadFragment extends BaseFragment {
    public boolean isInit = false;
    public boolean isLoad = false;


    @Override
    protected void init() {
        isInit = true;
        isCanLoadData();
    }

    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    public abstract void lazyLoad();

    public void stopLoad() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }
}
