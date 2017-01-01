package com.goo.musicdb.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class LikeMusic {
    @Id
    private Long id = null;
    private Long userId;
    private Long musicId;

    public LikeMusic(Long userId, Long musicId) {
        this.userId = userId;
        this.musicId = musicId;
    }

    @Generated(hash = 804552142)
    public LikeMusic(Long id, Long userId, Long musicId) {
        this.id = id;
        this.userId = userId;
        this.musicId = musicId;
    }

    @Generated(hash = 1538876461)
    public LikeMusic() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMusicId() {
        return this.musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

}
