package com.goo.musicdb.db;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;


/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class Music {
    @Id
    private Long musicId = null;
    private Long singerId;
    private Long specialId;
    private String musicName;
    private String lyric;
    private Date issueTime;

    public Music(Long singerId, Long specialId,
                 String musicName, String lyric, Date issueTime) {
        this.singerId = singerId;
        this.specialId = specialId;
        this.musicName = musicName;
        this.lyric = lyric;
        this.issueTime = issueTime;
    }

    @Override
    public String toString() {
        return "音乐ID：" + musicId + ";音乐名：" + musicName + ";歌手ID：" + singerId + ";所属歌单ID：" + specialId + ";歌词：" + lyric + ";发行时间：" + issueTime.toString();
    }

    @Generated(hash = 192510885)
    public Music(Long musicId, Long singerId, Long specialId, String musicName,
                 String lyric, Date issueTime) {
        this.musicId = musicId;
        this.singerId = singerId;
        this.specialId = specialId;
        this.musicName = musicName;
        this.lyric = lyric;
        this.issueTime = issueTime;
    }

    @Generated(hash = 1263212761)
    public Music() {
    }

    public Long getMusicId() {
        return this.musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public Long getSingerId() {
        return this.singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public Long getSpecialId() {
        return this.specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getLyric() {
        return this.lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public Date getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 67305069)
    public List<Comment> getComments() {
        if (comments == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentDao targetDao = daoSession.getCommentDao();
            List<Comment> commentsNew = targetDao._queryMusic_Comments(musicId);
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
    @Generated(hash = 1218270154)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMusicDao() : null;
    }

    @ToMany(referencedJoinProperty = "musicId")
    private List<Comment> comments;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1255683360)
    private transient MusicDao myDao;

}
