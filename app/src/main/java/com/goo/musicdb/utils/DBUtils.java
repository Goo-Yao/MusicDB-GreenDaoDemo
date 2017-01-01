package com.goo.musicdb.utils;

import android.content.Context;

import com.goo.musicdb.db.Comment;
import com.goo.musicdb.db.CommentDao;
import com.goo.musicdb.db.DaoSession;
import com.goo.musicdb.db.Music;
import com.goo.musicdb.db.MusicDao;
import com.goo.musicdb.db.Singer;
import com.goo.musicdb.db.SingerDao;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.db.SpecialDao;
import com.goo.musicdb.db.User;
import com.goo.musicdb.db.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;


/**
 * Created by Goo on 2016-12-28.
 */
public class DBUtils {
    private static Context context;
    private static DBManager manager;

    private static DaoSession session;

    private static class DBUtilsHolder {

        private static DBUtils instance = new DBUtils();

    }

    private DBUtils() {
        manager = DBManager.getInstance(context);
        session = manager.getDaoSession();
    }

    public static DBUtils getInstance(Context context) {
        DBUtils.context = context;
        return DBUtils.DBUtilsHolder.instance;
    }


    public List<Music> getUserMusic(User user) {
        QueryBuilder qbMusic = session.getMusicDao().queryBuilder()
                .where(new WhereCondition.StringCondition("_ID IN " + "(SELECT MUSIC_ID FROM LIKE_MUSIC WHERE USER_ID = " + user.getUserId() + ")"));
        return qbMusic.list();
    }

    public List<Special> getUserSpecial(User user) {
        QueryBuilder qbSpecial = session.getSpecialDao().queryBuilder()
                .where(new WhereCondition.StringCondition("_ID IN " + "(SELECT SPECIAL_ID FROM LIKE_SPECIAL WHERE USER_ID = " + user.getUserId() + ")"));
        return qbSpecial.list();
    }

    public List<Comment> getMusicComment(Music music) {
        QueryBuilder qbComment = session.getCommentDao().queryBuilder().where(CommentDao.Properties.MusicId.eq(music.getMusicId()));
        return qbComment.list();
    }

    public List<Comment> getUserComment(User user) {
        QueryBuilder qbComment = session.getCommentDao().queryBuilder().where(CommentDao.Properties.MusicId.eq(user.getUserId()));
        return qbComment.list();
    }

    public List<Music> getSpecialMusic(Special special) {
        return null;
    }

    public List<Singer> getMusicSinger(Music music) {
        return null;
    }

    public List<Special> getMusicSpecial(Music music) {
        return null;
    }

    public Music searchMusic(String musicName) {
        QueryBuilder qb = session.getMusicDao().queryBuilder().where(MusicDao.Properties.MusicName.eq(musicName));
        List<Music> musics = qb.list();
        if (musics.size() > 0) {
            return (Music) qb.list().get(0);
        } else {
            return null;
        }
    }

    public Special searchSpecial(String specialName) {
        QueryBuilder qb = session.getSpecialDao().queryBuilder().where(SpecialDao.Properties.SpecialIntroduction.eq(specialName));
        return (Special) qb.list().get(0);
    }

    public Special findSpById(long id) {
        QueryBuilder qb = session.getSpecialDao().queryBuilder().where(SpecialDao.Properties.SpecialId.eq(id));
        List<Special> specials = qb.list();
        if (specials.size() > 0) {
            return specials.get(0);
        } else {
            return null;
        }

    }

    public Singer findSingerById(Long singerId) {
        QueryBuilder qb = session.getSingerDao().queryBuilder().where(SingerDao.Properties.SingerId.eq(singerId));
        return (Singer) qb.list().get(0);
    }

    public User findUserById(Long userId) {
        QueryBuilder qb = session.getUserDao().queryBuilder().where(UserDao.Properties.UserId.eq(userId));
        return (User) qb.list().get(0);
    }

    public Music findMusicById(Long musicId) {
        QueryBuilder qb = session.getMusicDao().queryBuilder().where(MusicDao.Properties.MusicId.eq(musicId));
        List<Music> musics = qb.list();
        if (musics.size() > 0) {
            return musics.get(0);
        } else {
            return null;
        }

    }


    public boolean addMusic(Music music) {
        return session.getMusicDao().insert(music) > 0;
    }

    public boolean editMusic(Music music) {
        if (findMusicById(music.getMusicId()) != null) {
            session.getMusicDao().update(music);
            return true;
        }
        return false;
    }

    public List<Singer> searchSingerList(String strSearch) {
        QueryBuilder qb = session.getSingerDao().queryBuilder().where(SingerDao.Properties.Name.like("%" + strSearch + "%"));
        List<Singer> singers = qb.list();
        if (singers.size() > 0) {
            return singers;
        } else {
            return null;
        }
    }

    public List<Special> searchSpecialList(String strSearch) {
        QueryBuilder qb = session.getSpecialDao().queryBuilder().where(SpecialDao.Properties.SpecialIntroduction.like("%" + strSearch + "%"));
        List<Special> specials = qb.list();
        if (specials.size() > 0) {
            return specials;
        } else {
            return null;
        }
    }

    public List<Music> searchMusicList(String strSearch) {
        QueryBuilder qb = session.getMusicDao().queryBuilder().where(MusicDao.Properties.MusicName.like("%" + strSearch + "%"));
        List<Music> musics = qb.list();
        if (musics.size() > 0) {
            return musics;
        } else {
            return null;
        }
    }

    public boolean delMusic(long musicId) {
        if (findMusicById(musicId) != null) {
            session.getMusicDao().deleteByKey(musicId);
            return true;
        } else {
            return false;
        }
    }

}

