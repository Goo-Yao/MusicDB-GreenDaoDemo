package com.goo.musicdb.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MaterialEditText;
import android.widget.TextView;

import com.goo.musicdb.R;
import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.presenter.SearchPresenter;
import com.goo.musicdb.utils.RVItemDecoration;
import com.goo.musicdb.view.vinterface.SearchVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Goo on 2016-12-28.
 */

public class SearchActivity extends BaseSwipeBackActivity<SearchVInterface, SearchPresenter> implements SearchVInterface {
    @BindView(R.id.et_search)
    MaterialEditText etSearch;
    @BindView(R.id.tv_search_music)
    TextView tvSearchMusic;
    @BindView(R.id.tv_search_singer)
    TextView tvSearchSinger;
    @BindView(R.id.tv_search_special)
    TextView tvSearchSpecial;
    @BindView(R.id.rv_result)
    RecyclerView rvResult;


    public static final int MUSIC_TAG = 433;
    public static final int SP_TAG = 543;
    public static final int SINGER_TAG = 989;

    private int MODE_TAG = -1;

    private RVDefaultAdapter rvAdapter;

    @Override
    protected SearchPresenter createPresenter() {
        return new SearchPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_search;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("音乐匹配");
        initRv();
    }

    private void initRv() {
        rvAdapter = mPresenter.getRVAdapter();
        rvAdapter.setOnRvItemClickListener(new RVDefaultAdapter.OnRvItemClickListener() {
            @Override
            public void onItemClick(View view, RVDefaultItem rvDefaultItem) {
                if (MODE_TAG == MUSIC_TAG || MODE_TAG == SP_TAG) {
                    mPresenter.clickRv(rvDefaultItem.getTitle(), MODE_TAG);
                }
            }
        });
        rvResult.setLayoutManager(new LinearLayoutManager(this));
        rvResult.addItemDecoration(new RVItemDecoration());
        rvResult.setAdapter(rvAdapter);
    }


    @OnClick({R.id.tv_search_music, R.id.tv_search_singer, R.id.tv_search_special})
    public void onClick(View view) {
        String strSearch = etSearch.getText().toString();
        if (!strSearch.isEmpty()) {
            switch (view.getId()) {
                case R.id.tv_search_music:
                    MODE_TAG = MUSIC_TAG;
                    mPresenter.search(strSearch, MUSIC_TAG, rvAdapter);
                    break;
                case R.id.tv_search_singer:
                    MODE_TAG = SINGER_TAG;
                    mPresenter.search(strSearch, SINGER_TAG, rvAdapter);
                    break;
                case R.id.tv_search_special:
                    MODE_TAG = SP_TAG;
                    mPresenter.search(strSearch, SP_TAG, rvAdapter);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void toDetailActivity(int tag) {
        switch (tag) {
            case MUSIC_TAG:
                startActivityWithAnim(new Intent(SearchActivity.this, MusicActivity.class));
                break;
            case SP_TAG:
                startActivityWithAnim(new Intent(SearchActivity.this, SpecialActivity.class));
                break;
            default:
                break;

        }
    }
}
