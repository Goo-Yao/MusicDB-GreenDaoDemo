package com.goo.musicdb.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.goo.musicdb.R;
import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.presenter.MusicPresenter;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.RVItemDecoration;
import com.goo.musicdb.view.vinterface.MusicVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Goo on 2016-12-28.
 */

public class MusicActivity extends BaseSwipeBackActivity<MusicVInterface, MusicPresenter> implements MusicVInterface {
    @BindView(R.id.tv_music)
    TextView tvMusic;
    @BindView(R.id.rv_result)
    RecyclerView rvResult;

    private RVDefaultAdapter rvAdapter;

    @Override
    protected MusicPresenter createPresenter() {
        return new MusicPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_music;
    }

    @Override
    protected void initAttributes() {
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("音乐详情");
        tvMusic.setText(mPresenter.getMusicDetail(AppConstants.CURRENT_MUSIC));
        initRv();
    }

    private void initRv() {
        rvAdapter = mPresenter.getRVAdapter(AppConstants.CURRENT_MUSIC);
        rvResult.setLayoutManager(new LinearLayoutManager(this));
        rvResult.addItemDecoration(new RVItemDecoration());
        rvResult.setAdapter(rvAdapter);
    }

}
