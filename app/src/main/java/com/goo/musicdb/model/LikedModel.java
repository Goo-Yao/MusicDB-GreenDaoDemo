package com.goo.musicdb.model;

import android.content.Context;

import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.model.mInterface.LikedMInterface;
import com.goo.musicdb.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goo on 2016-12-28.
 */
public class LikedModel implements LikedMInterface {
    @Override
    public ArrayList<RVDefaultItem> getUserMusicData(Context context) {
        List<Music> musics = AppConstants.USER_LOGINED.getLikedMusics();
        ArrayList<RVDefaultItem> items = new ArrayList<>();
        for (int i = 0; i < musics.size(); i++) {
            Music temp = musics.get(i);
            items.add(new RVDefaultItem(temp.getMusicName(), temp.getLyric()));
        }
        return items;
    }

    @Override
    public ArrayList<RVDefaultItem> getUserSpecialData(Context context) {
        List<Special> specials = AppConstants.USER_LOGINED.getLikedSpecials();
        ArrayList<RVDefaultItem> items = new ArrayList<>();
        for (int i = 0; i < specials.size(); i++) {
            Special temp = specials.get(i);
            items.add(new RVDefaultItem(temp.getSpecialIntroduction(), temp.getIssueTime().toString() + "发布"));
        }
        return items;
    }


}
