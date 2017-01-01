package com.goo.musicdb.presenter;

import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.model.SearchModel;
import com.goo.musicdb.model.mInterface.SearchMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.DBUtils;
import com.goo.musicdb.view.activity.SearchActivity;
import com.goo.musicdb.view.vinterface.SearchVInterface;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-12-28.
 */

public class SearchPresenter extends BasePresenter<SearchVInterface> {
    private SearchMInterface model;

    public SearchPresenter(SearchVInterface viewInterface) {
        super(viewInterface);
        model = new SearchModel();
    }

    public RVDefaultAdapter getRVAdapter() {
        return new RVDefaultAdapter((SearchActivity) view, new ArrayList<RVDefaultItem>());
    }

    public void search(String strSearch, int tag, RVDefaultAdapter adapter) {
        adapter.setData(model.getSearchResult((SearchActivity) view, strSearch, tag));
    }

    /**
     * 点击事件
     */
    public void clickRv(String title, int tag) {
        switch (tag) {
            case SearchActivity.MUSIC_TAG:
                AppConstants.CURRENT_MUSIC = DBUtils.getInstance((SearchActivity) view).searchMusic(title);
                view.toDetailActivity(SearchActivity.MUSIC_TAG);
                break;
            case SearchActivity.SP_TAG:
                AppConstants.CURRENT_SPECIAL = DBUtils.getInstance((SearchActivity) view).searchSpecial(title);
                view.toDetailActivity(SearchActivity.SP_TAG);
                break;
            default:
                break;
        }
    }
}
