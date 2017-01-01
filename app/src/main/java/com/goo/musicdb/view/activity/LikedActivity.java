package com.goo.musicdb.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.goo.musicdb.R;
import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.presenter.LikedPresenter;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.RVItemDecoration;
import com.goo.musicdb.view.vinterface.LikedVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Goo on 2016-12-28.
 */
public class LikedActivity extends BaseSwipeBackActivity<LikedVInterface, LikedPresenter> implements LikedVInterface {
    @BindView(R.id.tv_user_logined)
    TextView tvUserLogined;
    @BindView(R.id.sw_mode)
    Switch swMode;
    @BindView(R.id.rv_result)
    RecyclerView rvResult;
    public static final int MUSIC_MODE = 457;
    public static final int SP_MODE = 523;
    private static int MODE_TAG = MUSIC_MODE;

    private RVDefaultAdapter rvAdapter;

    @Override
    protected LikedPresenter createPresenter() {
        return new LikedPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_liked;
    }

    @Override
    protected void initAttributes() {
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("我喜爱的");
        tvUserLogined.setText(AppConstants.USER_LOGINED.getAccountName());
        initSw();
        initRv();
    }

    private void initSw() {
        swMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //歌单模式
                    MODE_TAG = SP_MODE;
                    mPresenter.spMode(rvAdapter);
                } else {
                    //音乐模式
                    MODE_TAG = MUSIC_MODE;
                    mPresenter.musicMode(rvAdapter);
                }
            }
        });
    }

    private void initRv() {
        rvAdapter = mPresenter.getRVAdapter(this);
        rvAdapter.setOnRvItemClickListener(new RVDefaultAdapter.OnRvItemClickListener() {
            @Override
            public void onItemClick(View view, RVDefaultItem rvDefaultItem) {
                //点击音乐
                mPresenter.clickRv(rvDefaultItem.getTitle(), MODE_TAG);
            }
        });
        rvResult.setLayoutManager(new LinearLayoutManager(this));
        rvResult.addItemDecoration(new RVItemDecoration());
        rvResult.setAdapter(rvAdapter);
    }

    @Override
    public void toDetailActivity(int tag) {
        switch (tag) {
            case MUSIC_MODE:
                startActivityWithAnim(new Intent(LikedActivity.this, MusicActivity.class));
                break;
            case SP_MODE:
                startActivityWithAnim(new Intent(LikedActivity.this, SpecialActivity.class));
                break;
            default:
                break;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MODE_TAG = MUSIC_MODE;
    }
}
