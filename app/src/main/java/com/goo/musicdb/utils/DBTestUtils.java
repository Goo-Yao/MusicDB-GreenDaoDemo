package com.goo.musicdb.utils;

import android.content.Context;

import com.goo.musicdb.db.Comment;
import com.goo.musicdb.db.CommentDao;
import com.goo.musicdb.db.DaoSession;
import com.goo.musicdb.db.LikeMusic;
import com.goo.musicdb.db.LikeMusicDao;
import com.goo.musicdb.db.LikeSpecial;
import com.goo.musicdb.db.LikeSpecialDao;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.MusicDao;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.SingerDao;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.db.SpecialDao;
import com.goo.musicdb.db.User;
import com.goo.musicdb.db.UserDao;

import java.util.Date;

/**
 * Created by Goo on 2016-12-27.
 */

public class DBTestUtils {

    public static void initTestData(Context context) {
        DBManager dbManager = DBManager.getInstance(context);
        DaoSession session = dbManager.getDaoSession();
        //用户*20
        UserDao userDao = session.getUserDao();
        for (int i = 1; i <= 20; i++) {
            String userTestName = "内测用户" + i;
            String pswDefault = "123";
            userDao.insert(new User(userTestName, pswDefault, (int) (100 * (Math.random() + 0.01) + 0.5)));
        }
        //歌手*100
        SingerDao singerDao = session.getSingerDao();
        for (int i = 1; i <= 100; i++) {
            String singerTestName = "测试歌手" + i;
            String singerTestIntro = "测试歌手" + i + "闻名中外";
            singerDao.insert(new Singer(singerTestName, singerTestIntro));
        }
        //歌单*50
        SpecialDao specialDao = session.getSpecialDao();
        for (int i = 1; i <= 50; i++) {
            String testSpecial = "测试歌单" + i;
            specialDao.insert(new Special(new Date(2016, 12, 1), testSpecial));
        }
        //音乐*500
        MusicDao musicDao = session.getMusicDao();
        for (int i = 1; i <= 500; i++) {
            String musicTestName = "测试音乐" + i;
            String testLyric = "测试音乐" + i + "的歌词";
            //歌手、歌单、音乐名、歌词、发行时间
            musicDao.insert(new Music((long) (100 * (Math.random() + 0.01) + 0.5), (long) (50 * (Math.random() + 0.02) + 0.5), musicTestName, testLyric, new Date(2016, 1, 2)));
        }
        //评论*2000
        CommentDao commentDao = session.getCommentDao();
        for (int i = 1; i <= 2000; i++) {
            String testContent = "评论" + i + "的内容";
            commentDao.insert(new Comment(new Date(2016, 10, 12), testContent, (long) (20 * (Math.random() + 0.05)), (long) (500 * (Math.random() + 0.002))));
        }
        //喜爱的音乐*1000,与用户多对多
        LikeMusicDao likeMusicDao = session.getLikeMusicDao();
        for (int i = 1; i <= 1000; i++) {
            //用户id、音乐id
            likeMusicDao.insert(new LikeMusic((long) (20 * (Math.random() + 0.05) + 0.5), (long) (500 * (Math.random() + 0.002) + 0.5)));
        }
        //喜爱的歌单*100，与用户多对多
        LikeSpecialDao likeSpecialDao = session.getLikeSpecialDao();
        for (int i = 1; i <= 100; i++) {
            //用户id、歌单id
            likeSpecialDao.insert(new LikeSpecial((long) (20 * (Math.random() + 0.01) + 0.5), (long) (100 * (Math.random() + 0.01) + 0.5)));
        }
    }
}
