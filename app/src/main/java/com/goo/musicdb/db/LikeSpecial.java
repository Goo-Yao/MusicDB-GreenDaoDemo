package com.goo.musicdb.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class LikeSpecial {
    @Id
    private Long id = null;
    private Long userId;
    private Long specialId;

    public LikeSpecial(Long userId, Long specialId) {
        this.userId = userId;
        this.specialId = specialId;
    }

    @Generated(hash = 797354248)
    public LikeSpecial(Long id, Long userId, Long specialId) {
        this.id = id;
        this.userId = userId;
        this.specialId = specialId;
    }

    @Generated(hash = 1547598904)
    public LikeSpecial() {
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

    public Long getSpecialId() {
        return this.specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }
}
