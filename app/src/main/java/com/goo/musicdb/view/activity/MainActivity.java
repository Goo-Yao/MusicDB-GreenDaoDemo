package com.goo.musicdb.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.goo.musicdb.R;
import com.goo.musicdb.adapter.RVMainAdapter;
import com.goo.musicdb.base.BaseActivity;
import com.goo.musicdb.presenter.MainPresenter;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.DimenUtils;
import com.goo.musicdb.utils.ToastUtil;
import com.goo.musicdb.view.vinterface.MainVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import listener.HidingScrollListener;


public class MainActivity extends BaseActivity<MainVInterface, MainPresenter> implements MainVInterface, View.OnClickListener {
    @BindView(R.id.fab_submit)
    FloatingActionButton fabSubmit;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AppConstants.DATA_INIT_DONE:
                    dismissInitPD();
                    break;
                default:
                    dismissInitPD();
                    break;
            }
        }
    };

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAttributes() {
        isDoubleBackDestroy = true;
        mPresenter.initTestData(handler);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        initRv();
        fabSubmit.setOnClickListener(this);
    }

    @Override
    public void showInitPD() {
        showProgressDialog("数据初始化中,请稍候");
    }

    @Override
    public void dismissInitPD() {
        dismissProgressDialog();
    }

    @Override
    public void showTips(String tips) {
        ToastUtil.showToast(MainActivity.this, tips);
    }

    /**
     * 加载RecyclerView
     */
    private void initRv() {
        RVMainAdapter rvAdapter = mPresenter.getRVAdapter(this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(rvAdapter);
        rvMain.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideFAB();
            }

            @Override
            public void onShow() {
                showFAB();
            }
        });
        ItemTouchHelper itemHelper = mPresenter.getItemTouchHelper(rvAdapter);
        itemHelper.attachToRecyclerView(rvMain);
    }

    /**
     * 显示悬浮按钮
     */
    private void showFAB() {
        fabSubmit.animate().translationY(0).setInterpolator(new DecelerateInterpolator(1)).start();
    }

    /**
     * 隐藏悬浮按钮
     */
    private void hideFAB() {
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) fabSubmit.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        fabSubmit.animate().translationY(fabSubmit.getHeight() + fabBottomMargin + DimenUtils.getNavBarHeight(this) + DimenUtils.getStatusBarHeight(this)).
                setInterpolator(new AccelerateInterpolator(2)).start();
    }

    @Override
    public void startActivityWithAnim(String itemName) {
        if (itemName.equals("我喜爱的")) {
            startActivityWithAnim(new Intent(MainActivity.this, LikedActivity.class));
        } else if (itemName.equals("音乐匹配")) {
            startActivityWithAnim(new Intent(MainActivity.this, SearchActivity.class));
        } else if (itemName.equals("管理乐库")) {
            startActivityWithAnim(new Intent(MainActivity.this, ManageActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_submit:
                Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                startActivityWithAnim(intent);
                break;
        }
    }
}
