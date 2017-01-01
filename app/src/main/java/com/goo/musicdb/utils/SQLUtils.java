package com.goo.musicdb.utils;

import com.goo.musicdb.db.Music;

/**
 * Created by Goo on 2016-12-29.
 */

public class SQLUtils {


    /**
     * 获取用户喜爱的音乐
     */
    String getSQLUSERMUSIC(int userid) {
        return "SELECT MUSIC._ID FROM MUSIC "
                + "WHERE _ID IN (SELECT * FROM LIKE_MUSIC WHERE USER_ID=" + userid + ")";
    }


    /**
     * 获取用户喜爱的歌单
     */
    String getSQLUSERSPECIAL(int userid) {
        return "SELECT SPECIAL._ID FROM MUSIC "
                + "WHERE _ID IN (SELECT * FROM LIKE_SPECIAL WHERE USER_ID=" + userid + ")";
    }

    /**
     * 获取歌曲相应的评论
     */
    String getSQLMUSICCOMMENT(int musicid) {
        return "SELECT COMMENT._ID FROM COMMENT "
                + "WHERE MUSIC_ID =" + musicid;
    }

    /**
     * 获取歌单中的音乐
     */
    String getSQLSPECIALMUSIC(int specialid) {
        return "SELECT MUSIC._ID FROM MUSIC "
                + "WHERE SPECIAL_ID =" + specialid;
    }

    /**
     * 获取音乐实体信息
     */
    String getSQLMUSIC(int musicid) {
        return "SELECT * FROM MUSIC "
                + "WHERE MUSIC_ID =" + musicid;
    }

    /**
     * 获取评论实体信息
     */
    String getSQLCOMMENT(int comment) {
        return "SELECT * FROM COMMENT "
                + "WHERE COMMENT_ID =" + comment;
    }

    /**
     * 获取用户实体信息
     */
    String getSQLUSER(int userid) {
        return "SELECT * FROM USER "
                + "WHERE USER_ID =" + userid;
    }

    /**
     * 获取歌手实体信息
     */
    String getSQLSINGER(int singerid) {
        return "SELECT * FROM SINGER "
                + "WHERE SINGER_ID =" + singerid;
    }

    /**
     * 模糊搜索
     *
     * @param strSearch
     * @return
     */
    String getSQLSearchMUSIC(String strSearch) {
        return "SELECT * FROM MUSIC "
                + "WHERE MUSIC_NAME LIKE (%" + strSearch + "%)";
    }

    /**
     * 模糊搜索
     *
     * @param strSearch
     * @return
     */
    String getSQLSearchSINGER(String strSearch) {
        return "SELECT * FROM SINGER "
                + "WHERE SINGER_NAME LIKE (%" + strSearch + "%)";
    }

    /**
     * 模糊搜索
     *
     * @param strSearch
     * @return
     */
    String getSQLSearchSPECIAL(String strSearch) {
        return "SELECT * FROM SPECIAL "
                + "WHERE SPECIAL_INTRODUCTION LIKE (%" + strSearch + "%)";
    }

    /**
     * 添加音乐与歌手、歌单级联更新,与评论级联删除
     *
     * @return
     */
    String getSQLDELMUSIC() {
        return "ALTER TABLE MUSIC " +
                "ADD CONSTRAINT MUSIC_SINGER_CONSTRAINT FOREIGIN KEY (SINGER_ID) " +
                "REFERENCE SINGER (_ID) " +
                "ON UPDATE CASCADE " +
                "ADD CONSTRAINT MUSIC_SPECIAL_CONSTRAINT FOREIGIN KEY (SPECIAL_ID) " +
                "REFERENCE SPECIAL (_ID) " +
                "ON UPDATE CASCADE " +
                "ADD CONSTRAINT MUSIC_COMMENT_CONSTRAINT FOREIGIN KEY (COMMENT_ID) " +
                "REFERENCE COMMENT (_ID) " +
                "ON UPDATE CASCADE ON DELETE CASCADE";
    }

    /**
     * 添加音乐级联更新/删除
     */
    String delMUSIC(int musicid) {
        return "DELETE FROM MUSIC " +
                "MUSIC WHERE _ID=+" + musicid + ";";
    }


    /**
     * 歌手音乐级联更新/删除
     */
    String getSQLDELSINGER() {
        return "ALTER TABLE SINGER\n" +
                "        ADD CONSTRAINT SINGE_MUSIC_CONSTRAINT FOREIGIN KEY (SINGER_ID)\n" +
                "        REFERENCE MUSIC (SINGER_ID)\n" +
                "                ON UPDATE CASCADE ON DELETE CASCADE;";
    }

    /**
     * 歌手音乐级联更新/删除
     */
    String getSQLDELSPECIAL() {
        return "ALTER TABLE SINGER\n" +
                "        ADD CONSTRAINT SINGE_MUSIC_CONSTRAINT FOREIGIN KEY (SINGER_ID)\n" +
                "        REFERENCE MUSIC (SINGER_ID)\n" +
                "                ON UPDATE CASCADE ON DELETE CASCADE;";
    }

    /**
     * 更新音乐
     */
    String upgdateMUSIC(int musicid, Music music) {
        return "UPDATE MUSIC " +
                "SET SINGER_ID=" + music.getSingerId() + ",SPECIAL_ID=" + music.getSpecialId() + ",MUSIC_NAME=" + music.getMusicName()
                + "WHERE _ID=" + music;

    }


}
