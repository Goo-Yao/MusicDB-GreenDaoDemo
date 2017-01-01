package com.goo.musicdb.db;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class Singer {
    @Id
    private Long singerId = null;
    private String name;
    private String singerIntroduction;

    @ToMany(referencedJoinProperty = "singerId")
    private List<Music> musics;

    public Singer(String name, String singerIntroduction) {
        this.name = name;
        this.singerIntroduction = singerIntroduction;
    }

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 183933131)
    private transient SingerDao myDao;


    @Generated(hash = 406969602)
    public Singer(Long singerId, String name, String singerIntroduction) {
        this.singerId = singerId;
        this.name = name;
        this.singerIntroduction = singerIntroduction;
    }

    @Generated(hash = 242898301)
    public Singer() {
    }

    public Long getSingerId() {
        return this.singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerIntroduction() {
        return this.singerIntroduction;
    }

    public void setSingerIntroduction(String singerIntroduction) {
        this.singerIntroduction = singerIntroduction;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 549167100)
    public List<Music> getMusics() {
        if (musics == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MusicDao targetDao = daoSession.getMusicDao();
            List<Music> musicsNew = targetDao._querySinger_Musics(singerId);
            synchronized (this) {
                if (musics == null) {
                    musics = musicsNew;
                }
            }
        }
        return musics;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1369131536)
    public synchronized void resetMusics() {
        musics = null;
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
    @Generated(hash = 938712516)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSingerDao() : null;
    }


}
