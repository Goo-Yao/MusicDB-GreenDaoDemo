package com.goo.musicdb.presenter;

import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.db.User;
import com.goo.musicdb.model.LoginModel;
import com.goo.musicdb.model.mInterface.LoginMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.view.activity.LoginActivity;
import com.goo.musicdb.view.vinterface.LoginVInterface;

import java.util.List;

/**
 * Created by Goo on 2016-12-27.
 */

public class LoginPresenter extends BasePresenter<LoginVInterface> {
    private LoginMInterface model;

    public LoginPresenter(LoginVInterface viewInterface) {
        super(viewInterface);
        model = new LoginModel();
    }

    public void login(final String accountName, final String psw) {
        boolean accountExist = false;
        if (!isEmpty(accountName, psw)) {
            List<User> users = model.getAllUsers((LoginActivity) view);
            for (int i = 0; i < users.size(); i++) {
                User temp = users.get(i);
                if (temp.getAccountName().equals(accountName)) {
                    accountExist = true;
                    if (temp.getPsw().equals(psw)) {
                        AppConstants.USER_LOGINED = temp;
                        view.loginSuccess();
                    } else {
                        view.showTips("密码错误，请重新尝试");
                    }
                    break;
                }
            }
            if (!accountExist) {
                view.showTips("没有找到该用户，请尝试注册");
            }
        }
    }

    public void register(String accountName, String psw) {
        if (!isEmpty(accountName, psw)) {
            List<User> users = model.getAllUsers((LoginActivity) view);
            boolean accountExist = false;
            for (int i = 0; i < users.size(); i++) {
                User temp = users.get(i);
                if (temp.getAccountName().equals(accountName)) {
                    accountExist = true;
                    view.showTips("用户名已存在");
                }
            }
            if (!accountExist) {
                User user = new User();
                user.setAccountName(accountName);
                user.setPsw(psw);
                if (model.insertUser((LoginActivity) view, user)) {
                    view.showTips("注册成功，现在可以登录啦!");
                }
            }
        }
    }

    private boolean isEmpty(String accountName, String psw) {
        if (accountName.isEmpty() || psw.isEmpty()) {
            view.showTips("请完整填写信息");
            return true;
        }
        return false;
    }
}
