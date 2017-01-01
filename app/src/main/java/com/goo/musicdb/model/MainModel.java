package com.goo.musicdb.model;


import android.content.Context;

import com.goo.musicdb.entity.MainItemInfo;
import com.goo.musicdb.model.mInterface.MainMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.DBTestUtils;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-12-26.
 */
public class MainModel implements MainMInterface {
    @Override
    public void initTestData(Context context) {
        DBTestUtils.initTestData(context);
    }

    @Override
    public ArrayList<MainItemInfo> getAMData() {
        ArrayList<MainItemInfo> data = new ArrayList<>();
        data.add(new MainItemInfo("我喜爱的", "#FBC02D", AppConstants.USER_LOGINED.getAccountName() + " 用户喜爱的音乐信息"));
        data.add(new MainItemInfo("音乐匹配", "#377EB4", "搜索乐库中的音乐信息"));
        data.add(new MainItemInfo("管理乐库", "#8BC34A", "添加、修改或删除音乐"));
        data.add(new MainItemInfo("更多功能", "#9E9E9E", "未来可能推出新功能..."));
        return data;
    }
}
