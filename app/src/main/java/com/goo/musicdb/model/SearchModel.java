package com.goo.musicdb.model;

import android.content.Context;

import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.model.mInterface.SearchMInterface;
import com.goo.musicdb.utils.DBUtils;
import com.goo.musicdb.view.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goo on 2016-12-28.
 */
public class SearchModel implements SearchMInterface {


    @Override
    public ArrayList<RVDefaultItem> getSearchResult(Context context, String strSearch, int tag) {
        ArrayList<RVDefaultItem> items = new ArrayList<>();
        switch (tag) {
            case SearchActivity.MUSIC_TAG:
                List<Music> musics = DBUtils.getInstance(context).searchMusicList(strSearch);
                if (musics != null) {
                    for (int i = 0; i < musics.size(); i++) {
                        Music temp = musics.get(i);
                        items.add(new RVDefaultItem(temp.getMusicName(), temp.getLyric()));
                    }
                }
                return items;
            case SearchActivity.SINGER_TAG:
                List<Singer> singers = DBUtils.getInstance(context).searchSingerList(strSearch);
                if (singers != null) {
                    for (int i = 0; i < singers.size(); i++) {
                        Singer temp = singers.get(i);
                        items.add(new RVDefaultItem(temp.getName(), temp.getSingerIntroduction()));
                    }
                }
                return items;
            case SearchActivity.SP_TAG:
                List<Special> specials = DBUtils.getInstance(context).searchSpecialList(strSearch);
                if (specials != null) {
                    for (int i = 0; i < specials.size(); i++) {
                        Special temp = specials.get(i);
                        items.add(new RVDefaultItem(temp.getSpecialIntroduction(), temp.getIssueTime().toString() + "发布"));
                    }
                }
                return items;
            default:
                break;
        }
        return null;
    }
}
