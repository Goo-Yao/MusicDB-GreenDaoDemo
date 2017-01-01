package com.goo.musicdb.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.goo.musicdb.R;
import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.presenter.SpecialPresenter;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.RVItemDecoration;
import com.goo.musicdb.view.vinterface.SpecialVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Goo on 2016-12-28.
 */

public class SpecialActivity extends BaseSwipeBackActivity<SpecialVInterface, SpecialPresenter> implements SpecialVInterface {
    @BindView(R.id.tv_special)
    TextView tvSpecial;
    @BindView(R.id.rv_result)
    RecyclerView rvResult;

    private RVDefaultAdapter rvAdapter;

    @Override
    protected SpecialPresenter createPresenter() {
        return new SpecialPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_special;
    }

    @Override
    protected void initAttributes() {
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("歌单详情");
        tvSpecial.setText(mPresenter.getSpecialDetail(AppConstants.CURRENT_SPECIAL));
        initRv();
    }

    private void initRv() {
        rvAdapter = mPresenter.getRVAdapter(AppConstants.CURRENT_SPECIAL);
        rvResult.setLayoutManager(new LinearLayoutManager(this));
        rvResult.addItemDecoration(new RVItemDecoration());
        rvResult.setAdapter(rvAdapter);
    }

}
