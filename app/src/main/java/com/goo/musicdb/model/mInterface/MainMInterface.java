package com.goo.musicdb.model.mInterface;

import android.content.Context;

import com.goo.musicdb.entity.MainItemInfo;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-10-26.
 */

public interface MainMInterface {
    void initTestData(Context context);

    ArrayList<MainItemInfo> getAMData();
}
