package com.goo.musicdb.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.goo.musicdb.db.Comment;
import com.goo.musicdb.db.LikeMusic;
import com.goo.musicdb.db.LikeSpecial;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.db.User;

import com.goo.musicdb.db.CommentDao;
import com.goo.musicdb.db.LikeMusicDao;
import com.goo.musicdb.db.LikeSpecialDao;
import com.goo.musicdb.db.MusicDao;
import com.goo.musicdb.db.SingerDao;
import com.goo.musicdb.db.SpecialDao;
import com.goo.musicdb.db.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig commentDaoConfig;
    private final DaoConfig likeMusicDaoConfig;
    private final DaoConfig likeSpecialDaoConfig;
    private final DaoConfig musicDaoConfig;
    private final DaoConfig singerDaoConfig;
    private final DaoConfig specialDaoConfig;
    private final DaoConfig userDaoConfig;

    private final CommentDao commentDao;
    private final LikeMusicDao likeMusicDao;
    private final LikeSpecialDao likeSpecialDao;
    private final MusicDao musicDao;
    private final SingerDao singerDao;
    private final SpecialDao specialDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        commentDaoConfig = daoConfigMap.get(CommentDao.class).clone();
        commentDaoConfig.initIdentityScope(type);

        likeMusicDaoConfig = daoConfigMap.get(LikeMusicDao.class).clone();
        likeMusicDaoConfig.initIdentityScope(type);

        likeSpecialDaoConfig = daoConfigMap.get(LikeSpecialDao.class).clone();
        likeSpecialDaoConfig.initIdentityScope(type);

        musicDaoConfig = daoConfigMap.get(MusicDao.class).clone();
        musicDaoConfig.initIdentityScope(type);

        singerDaoConfig = daoConfigMap.get(SingerDao.class).clone();
        singerDaoConfig.initIdentityScope(type);

        specialDaoConfig = daoConfigMap.get(SpecialDao.class).clone();
        specialDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        commentDao = new CommentDao(commentDaoConfig, this);
        likeMusicDao = new LikeMusicDao(likeMusicDaoConfig, this);
        likeSpecialDao = new LikeSpecialDao(likeSpecialDaoConfig, this);
        musicDao = new MusicDao(musicDaoConfig, this);
        singerDao = new SingerDao(singerDaoConfig, this);
        specialDao = new SpecialDao(specialDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Comment.class, commentDao);
        registerDao(LikeMusic.class, likeMusicDao);
        registerDao(LikeSpecial.class, likeSpecialDao);
        registerDao(Music.class, musicDao);
        registerDao(Singer.class, singerDao);
        registerDao(Special.class, specialDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        commentDaoConfig.clearIdentityScope();
        likeMusicDaoConfig.clearIdentityScope();
        likeSpecialDaoConfig.clearIdentityScope();
        musicDaoConfig.clearIdentityScope();
        singerDaoConfig.clearIdentityScope();
        specialDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public LikeMusicDao getLikeMusicDao() {
        return likeMusicDao;
    }

    public LikeSpecialDao getLikeSpecialDao() {
        return likeSpecialDao;
    }

    public MusicDao getMusicDao() {
        return musicDao;
    }

    public SingerDao getSingerDao() {
        return singerDao;
    }

    public SpecialDao getSpecialDao() {
        return specialDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
