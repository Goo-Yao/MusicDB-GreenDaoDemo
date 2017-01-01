package com.goo.musicdb.presenter;

import android.content.Context;

import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.model.LikedModel;
import com.goo.musicdb.model.mInterface.LikedMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.DBUtils;
import com.goo.musicdb.view.activity.LikedActivity;
import com.goo.musicdb.view.vinterface.LikedVInterface;

/**
 * Created by Goo on 2016-12-28.
 */

public class LikedPresenter extends BasePresenter<LikedVInterface> {
    private LikedMInterface model;

    public LikedPresenter(LikedVInterface viewInterface) {
        super(viewInterface);
        model = new LikedModel();
    }

    public RVDefaultAdapter getRVAdapter(Context context) {
        RVDefaultAdapter adapter = new RVDefaultAdapter(context, model.getUserMusicData((LikedActivity) view));
        return adapter;
    }

    public void spMode(RVDefaultAdapter rvAdapter) {
        rvAdapter.setData(model.getUserSpecialData((LikedActivity) view));
    }

    public void musicMode(RVDefaultAdapter rvAdapter) {
        rvAdapter.setData(model.getUserMusicData((LikedActivity) view));
    }

    /**
     * 点击事件
     *
     * @param title
     * @param modeTag
     */
    public void clickRv(String title, int modeTag) {
        switch (modeTag) {
            case LikedActivity.MUSIC_MODE:
                Music music = DBUtils.getInstance((LikedActivity) view).searchMusic(title);
                if (music != null) {
                    AppConstants.CURRENT_MUSIC = music;
                    view.toDetailActivity(LikedActivity.MUSIC_MODE);
                }
                break;
            case LikedActivity.SP_MODE:
                AppConstants.CURRENT_SPECIAL = DBUtils.getInstance((LikedActivity) view).searchSpecial(title);
                view.toDetailActivity(LikedActivity.SP_MODE);
                break;
            default:
                break;
        }

    }
}
