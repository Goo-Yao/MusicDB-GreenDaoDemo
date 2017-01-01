package com.goo.musicdb.model.mInterface;

import android.content.Context;

import com.goo.musicdb.db.User;

import java.util.List;

/**
 * Created by Goo on 2016-12-27.
 */

public interface LoginMInterface {
    List<User> getAllUsers(Context context);

    boolean insertUser(Context context, User user);

}
