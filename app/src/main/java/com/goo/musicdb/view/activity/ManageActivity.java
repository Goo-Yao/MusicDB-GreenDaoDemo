package com.goo.musicdb.view.activity;

import android.view.View;
import android.widget.MaterialEditText;
import android.widget.TextView;

import com.goo.musicdb.R;
import com.goo.musicdb.base.BaseSwipeBackActivity;
import com.goo.musicdb.presenter.ManagePresenter;
import com.goo.musicdb.utils.ToastUtil;
import com.goo.musicdb.view.vinterface.ManageVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Goo on 2016-12-28.
 */

public class ManageActivity extends BaseSwipeBackActivity<ManageVInterface, ManagePresenter> implements ManageVInterface {
    @BindView(R.id.et_id)
    MaterialEditText etId;
    @BindView(R.id.et_singer_id)
    MaterialEditText etSingerId;
    @BindView(R.id.et_special_id)
    MaterialEditText etSpecialId;
    @BindView(R.id.et_name)
    MaterialEditText etName;
    @BindView(R.id.tv_del)
    TextView tvDel;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected ManagePresenter createPresenter() {
        return new ManagePresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showToolbarAndShowNavigation("管理乐库");
    }


    @OnClick({R.id.tv_del, R.id.tv_add, R.id.tv_edit})
    public void onClick(View view) {
        String strId = etId.getText().toString();
        String strSingerId = etSingerId.getText().toString();
        String strSpecialId = etSpecialId.getText().toString();
        String strName = etName.getText().toString();

        switch (view.getId()) {
            case R.id.tv_del:
                if (!strId.isEmpty()) {
                    mPresenter.delMusic(strId);
                } else {
                    ToastUtil.showToast(ManageActivity.this, "请补全需要删除的音乐ID");
                }
                break;
            case R.id.tv_add:
                if (!(strSingerId.isEmpty() || strSpecialId.isEmpty() || strName.isEmpty())) {
                    mPresenter.addMusic(strSingerId, strSpecialId, strName);
                } else {
                    ToastUtil.showToast(ManageActivity.this, "请补全歌手ID、歌单ID以及音乐名");
                }
                break;
            case R.id.tv_edit:
                if (!(strId.isEmpty() || strSingerId.isEmpty() || strSpecialId.isEmpty() || strName.isEmpty())) {
                    mPresenter.editMusic(strId, strSingerId, strSpecialId, strName);
                } else {
                    ToastUtil.showToast(ManageActivity.this, "请补全未填写信息");
                }
                break;
        }
    }

    @Override
    public void showTips(String tips) {
        tvResult.setText(tips);
    }
}
