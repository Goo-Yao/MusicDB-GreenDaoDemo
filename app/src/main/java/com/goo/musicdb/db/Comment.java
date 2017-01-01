package com.goo.musicdb.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;


/**
 * Created by Goo on 2016-12-27.
 */
@Entity
public class Comment {
    @Id
    private Long commentId = null;
    private Date postTime;
    private String content;
    private Long userId;
    private Long musicId;

    public Comment(Date postTime, String content, Long userId,
                   Long musicId) {
        this.postTime = postTime;
        this.content = content;
        this.userId = userId;
        this.musicId = musicId;
    }

    @Generated(hash = 677143259)
    public Comment(Long commentId, Date postTime, String content, Long userId,
                   Long musicId) {
        this.commentId = commentId;
        this.postTime = postTime;
        this.content = content;
        this.userId = userId;
        this.musicId = musicId;
    }

    @Generated(hash = 1669165771)
    public Comment() {
    }

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getPostTime() {
        return this.postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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
