package com.goo.musicdb.model;

import android.content.Context;

import com.goo.musicdb.db.User;
import com.goo.musicdb.model.mInterface.LoginMInterface;
import com.goo.musicdb.utils.DBManager;

import java.util.List;

/**
 * Created by Goo on 2016-12-27.
 */

public class LoginModel implements LoginMInterface {
    @Override
    public List<User> getAllUsers(Context context) {
        return DBManager.getInstance(context).getDaoSession().getUserDao().queryBuilder().build().list();
    }

    @Override
    public boolean insertUser(Context context, User user) {
        return DBManager.getInstance(context).getDaoSession().getUserDao().insert(user) > 0;
    }

}
