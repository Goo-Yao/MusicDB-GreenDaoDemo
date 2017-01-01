package com.goo.musicdb.view.vinterface;

/**
 * @author Goo
 * @since 2016-12-27
 */

public interface MainVInterface {
    void showInitPD();

    void dismissInitPD();

    void showTips(String tips);

    void startActivityWithAnim(String itemName);
}
