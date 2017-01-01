package com.goo.musicdb.model;

import android.content.Context;

import com.goo.musicdb.db.Music;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.model.mInterface.SpecialMInterface;
import com.goo.musicdb.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goo on 2016-12-28.
 */
public class SpecialModel implements SpecialMInterface {
    @Override
    public ArrayList<RVDefaultItem> getMusicData(Context context) {
        List<Music> musics = AppConstants.CURRENT_SPECIAL.getInnerMusics();
        ArrayList<RVDefaultItem> items = new ArrayList<>();
        for (int i = 0; i < musics.size(); i++) {
            Music temp = musics.get(i);
            items.add(new RVDefaultItem(temp.getMusicName(), temp.getLyric()));
        }
        return items;
    }
}
