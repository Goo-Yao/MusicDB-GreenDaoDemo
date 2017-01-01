package com.goo.musicdb.db;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class User {
    @Id
    private Long userId = null;
    @Unique
    private String accountName;
    private String psw;
    private int age;
    @ToMany(referencedJoinProperty = "userId")
    private List<Comment> comments;

    public User(String accountName, String psw, int age) {
        this.accountName = accountName;
        this.psw = psw;
        this.age = age;
    }

    @Generated(hash = 704136557)
    public User(Long userId, String accountName, String psw, int age) {
        this.userId = userId;
        this.accountName = accountName;
        this.psw = psw;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPsw() {
        return this.psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 586223739)
    public List<Comment> getComments() {
        if (comments == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentDao targetDao = daoSession.getCommentDao();
            List<Comment> commentsNew = targetDao._queryUser_Comments(userId);
            synchronized (this) {
                if (comments == null) {
                    comments = commentsNew;
                }
            }
        }
        return comments;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 249603048)
    public synchronized void resetComments() {
        comments = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 75978546)
    public List<Music> getLikedMusics() {
        if (likedMusics == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MusicDao targetDao = daoSession.getMusicDao();
            List<Music> likedMusicsNew = targetDao._queryUser_LikedMusics(userId);
            synchronized (this) {
                if (likedMusics == null) {
                    likedMusics = likedMusicsNew;
                }
            }
        }
        return likedMusics;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1559022631)
    public synchronized void resetLikedMusics() {
        likedMusics = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1532348309)
    public List<Special> getLikedSpecials() {
        if (likedSpecials == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SpecialDao targetDao = daoSession.getSpecialDao();
            List<Special> likedSpecialsNew = targetDao
                    ._queryUser_LikedSpecials(userId);
            synchronized (this) {
                if (likedSpecials == null) {
                    likedSpecials = likedSpecialsNew;
                }
            }
        }
        return likedSpecials;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1104557155)
    public synchronized void resetLikedSpecials() {
        likedSpecials = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

    @ToMany
    @JoinEntity(
            entity = LikeMusic.class,
            sourceProperty = "userId",
            targetProperty = "musicId"
    )
    private List<Music> likedMusics;

    @ToMany
    @JoinEntity(
            entity = LikeSpecial.class,
            sourceProperty = "userId",
            targetProperty = "specialId"
    )
    private List<Special> likedSpecials;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

}
