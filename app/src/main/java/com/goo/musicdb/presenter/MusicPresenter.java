package com.goo.musicdb.presenter;

import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.model.MusicModel;
import com.goo.musicdb.model.mInterface.MusicMInterface;
import com.goo.musicdb.utils.DBUtils;
import com.goo.musicdb.view.activity.MusicActivity;
import com.goo.musicdb.view.vinterface.MusicVInterface;

/**
 * Created by Goo on 2016-12-28.
 */

public class MusicPresenter extends BasePresenter<MusicVInterface> {
    private MusicMInterface model;

    public MusicPresenter(MusicVInterface viewInterface) {
        super(viewInterface);
        model = new MusicModel();
    }

    //获取歌手、专辑
    public String getMusicDetail(Music music) {
        String result = "";
        Singer singer = DBUtils.getInstance((MusicActivity) view).findSingerById(music.getSingerId());
        Special sp = DBUtils.getInstance((MusicActivity) view).findSpById(music.getSpecialId());
        String strSp = "";
        if (sp != null) {
            strSp = "\n歌单：" + sp.getSpecialIntroduction();
        }
        result += music.getMusicName() + " - 歌手：" + singer.getName() + strSp;
        return result;
    }

    public RVDefaultAdapter getRVAdapter(Music music) {
        return new RVDefaultAdapter((MusicActivity) view, model.getCommentData((MusicActivity) view));
    }
}
