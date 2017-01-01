package com.goo.musicdb.presenter;

import android.content.Context;

import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.utils.DBUtils;
import com.goo.musicdb.view.vinterface.ManageVInterface;

import java.util.Date;

/**
 * Created by Goo on 2016-12-28.
 */

public class ManagePresenter extends BasePresenter<ManageVInterface> {
    public ManagePresenter(ManageVInterface viewInterface) {
        super(viewInterface);
    }

    public void delMusic(String strId) {
        long musicId = Long.valueOf(strId);
        if (DBUtils.getInstance((Context) view).delMusic(musicId)) {
            view.showTips("音乐ID为" + strId + "的音乐删除成功");

        } else {
            view.showTips("该音乐ID不存在,删除失败");
        }
    }

    public void addMusic(String strSingerId, String strSpecialId, String strName) {
        long singerId = Long.valueOf(strSingerId);
        long spId = Long.valueOf(strSpecialId);
        if (singerId > 0 && singerId <= 100 && spId > 0 && spId <= 50) {
            Music music = new Music(singerId, spId, strName, "新增音乐的歌词", new Date(2016, 12, 29));
            if (DBUtils.getInstance((Context) view).addMusic(music)) {
                view.showTips("添加成功：" + music.toString());
            } else {
                view.showTips("添加失败");
            }
        } else {
            view.showTips("请确保歌手ID与歌单ID为正确范围数值");
        }
    }

    public void editMusic(String strId, String strSingerId, String strSpecialId, String strName) {
        long musicId = Long.valueOf(strId);
        long singerId = Long.valueOf(strSingerId);
        long spId = Long.valueOf(strSpecialId);

        if (singerId > 0 && singerId <= 100 && spId > 0 && spId <= 50) {
            Music music = new Music(musicId, singerId, spId, strName, "修改过的音乐的歌词", new Date(2016, 12, 29));
            if (DBUtils.getInstance((Context) view).editMusic(music)) {
                view.showTips("修改成功：" + music.toString());
            } else {
                view.showTips("修改失败");
            }
        } else {
            view.showTips("请确保歌手ID与歌单ID为正确范围数值");
        }
    }
}
