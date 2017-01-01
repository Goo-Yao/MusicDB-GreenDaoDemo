package com.goo.musicdb.model;

import android.content.Context;

import com.goo.musicdb.db.Comment;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.model.mInterface.MusicMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goo on 2016-12-28.
 */
public class MusicModel implements MusicMInterface {
    @Override
    public ArrayList<RVDefaultItem> getCommentData(Context context) {
        List<Comment> comments = AppConstants.CURRENT_MUSIC.getComments();
        ArrayList<RVDefaultItem> items = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            Comment temp = comments.get(i);
            String userName = DBUtils.getInstance(context).findUserById(temp.getUserId()).getAccountName();
            items.add(new RVDefaultItem(temp.getContent(), userName + temp.getPostTime()));
        }
        return items;
    }
}
