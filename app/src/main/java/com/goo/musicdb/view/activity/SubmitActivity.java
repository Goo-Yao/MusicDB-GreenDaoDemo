package com.goo.musicdb.view.activity;

import android.webkit.WebView;

import com.goo.musicdb.R;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.presenter.SubmitPresenter;
import com.goo.musicdb.view.vinterface.SubmitVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SubmitActivity extends BaseSwipeBackActivity<SubmitVInterface, SubmitPresenter> implements SubmitVInterface {

    @BindView(R.id.wv_info)
    WebView wvInfo;

    @Override
    protected SubmitPresenter createPresenter() {
        return new SubmitPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_submit;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("反馈");
        wvInfo.loadUrl("file:///android_asset/info.html");
    }

}
