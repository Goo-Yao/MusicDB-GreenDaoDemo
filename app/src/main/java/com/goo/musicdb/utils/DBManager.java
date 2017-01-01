package com.goo.musicdb.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.goo.musicdb.db.DaoMaster;
import com.goo.musicdb.db.DaoSession;

/**
 * DB管理类
 * Created by Goo on 2016-12-27.
 */
public class DBManager {
    private static final String DB_NAME = "MusicDB";
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static Context context = null;

    private static class DBManagerHolder {
        private static DBManager instance = new DBManager(context);
    }

    private DBManager(Context context) {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        mDaoMaster = new DaoMaster(getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static DBManager getInstance(Context context) {
        DBManager.context = context;
        return DBManagerHolder.instance;
    }

    /**
     * 获取可读数据库
     */
    public SQLiteDatabase getReadableDatabase() {
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     **/
    public SQLiteDatabase getWritableDatabase() {
        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     **/
    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    /**
     * 获取DaoSession
     **/
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
