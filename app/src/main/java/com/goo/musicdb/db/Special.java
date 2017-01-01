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
public class Special {
    @Id
    private Long specialId = null;
    private Date issueTime;
    private String specialIntroduction;

    @ToMany(referencedJoinProperty = "specialId")
    private List<Music> innerMusics;


    public Special(Date issueTime, String specialIntroduction) {
        this.issueTime = issueTime;
        this.specialIntroduction = specialIntroduction;
    }
    /** Used to resolve relations */
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1692422082)
    private transient SpecialDao myDao;

    @Generated(hash = 1909412832)
    public Special(Long specialId, Date issueTime, String specialIntroduction) {
        this.specialId = specialId;
        this.issueTime = issueTime;
        this.specialIntroduction = specialIntroduction;
    }

    public Long getSpecialId() {
        return this.specialId;
    }

    @Generated(hash = 893627082)
    public Special() {
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public Date getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getSpecialIntroduction() {
        return this.specialIntroduction;
    }

    public void setSpecialIntroduction(String specialIntroduction) {
        this.specialIntroduction = specialIntroduction;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1032483758)
    public List<Music> getInnerMusics() {
        if (innerMusics == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MusicDao targetDao = daoSession.getMusicDao();
            List<Music> innerMusicsNew = targetDao
                    ._querySpecial_InnerMusics(specialId);
            synchronized (this) {
                if (innerMusics == null) {
                    innerMusics = innerMusicsNew;
                }
            }
        }
        return innerMusics;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 484045684)
    public synchronized void resetInnerMusics() {
        innerMusics = null;
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
    @Generated(hash = 1837080705)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSpecialDao() : null;
    }


}
