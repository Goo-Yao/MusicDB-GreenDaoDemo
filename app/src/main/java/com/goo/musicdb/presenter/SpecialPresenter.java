package com.goo.musicdb.presenter;

import com.goo.musicdb.adapter.RVDefaultAdapter;
import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.db.Special;
import com.goo.musicdb.model.SpecialModel;
import com.goo.musicdb.model.mInterface.SpecialMInterface;
import com.goo.musicdb.view.activity.SpecialActivity;
import com.goo.musicdb.view.vinterface.SpecialVInterface;

/**
 * Created by Goo on 2016-12-28.
 */

public class SpecialPresenter extends BasePresenter<SpecialVInterface> {
    private SpecialMInterface model;

    public SpecialPresenter(SpecialVInterface viewInterface) {
        super(viewInterface);
        model = new SpecialModel();
    }

    //获取名字、发布时间
    public String getSpecialDetail(Special special) {
        String result = "";
        result += special.getSpecialIntroduction() + "\n发布于：" + special.getIssueTime().toString();
        return result;
    }

    public RVDefaultAdapter getRVAdapter(Special special) {
        return new RVDefaultAdapter((SpecialActivity) view, model.getMusicData((SpecialActivity) view));
    }

}
