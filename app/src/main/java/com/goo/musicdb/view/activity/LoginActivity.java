package com.goo.musicdb.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.MaterialEditText;

import com.goo.musicdb.R;
import com.goo.musicdb.base.BaseActivity;
import com.goo.musicdb.presenter.LoginPresenter;
import com.goo.musicdb.utils.ToastUtil;
import com.goo.musicdb.view.vinterface.LoginVInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Goo on 2016-12-27.
 */
public class LoginActivity extends BaseActivity<LoginVInterface, LoginPresenter> implements LoginVInterface {
    @BindView(R.id.et_account)
    MaterialEditText etAccount;
    @BindView(R.id.et_psw)
    MaterialEditText etPsw;
    @BindView(R.id.btn_login_confirm)
    Button btnLoginConfirm;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_login;
    }

    @Override
    protected void initAttributes() {
        isDoubleBackDestroy = true;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    public void showTips(String tips) {
        ToastUtil.showToast(this, tips);
    }

    @Override
    public void loginSuccess() {
        startActivityWithAnimAndDestroy(new Intent(LoginActivity.this, MainActivity.class));
    }


    @OnClick({R.id.btn_login_confirm, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_confirm:
                mPresenter.login(etAccount.getText().toString(), etPsw.getText().toString());
                break;
            case R.id.btn_register:
                mPresenter.register(etAccount.getText().toString(), etPsw.getText().toString());
                break;
        }
    }
}
