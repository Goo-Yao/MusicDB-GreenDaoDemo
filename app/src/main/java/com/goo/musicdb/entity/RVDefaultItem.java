package com.goo.musicdb.entity;

/**
 * Created by Goo on 2016-12-28.
 */

public class RVDefaultItem {
    private String title;
    private String subTitle;

    public RVDefaultItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
