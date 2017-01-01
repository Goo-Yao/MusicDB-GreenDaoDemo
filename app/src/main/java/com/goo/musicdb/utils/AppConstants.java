package com.goo.musicdb.utils;

import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.db.User;

/**
 * 常量管理类
 */
public class AppConstants {
    public static final int OUT_PENDING_TRANSITION = 10;
    public static final int OPEN_PENDING_TRANSITION = 20;

    public static final int DATA_INIT_DONE = 143;

    public static final String INIT_DATA_KEY = "INIT_DATA_KEY";

    public static User USER_LOGINED = null;
    public static Music CURRENT_MUSIC = null;
    public static Singer CURRENT_SINGER = null;
    public static Special CURRENT_SPECIAL = null;


}
