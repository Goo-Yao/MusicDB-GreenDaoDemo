package com.goo.musicdb.model.mInterface;

import android.content.Context;

import com.goo.musicdb.entity.RVDefaultItem;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-12-28.
 */

public interface SearchMInterface {
    ArrayList<RVDefaultItem> getSearchResult(Context context, String strSearch, int tag);
}
