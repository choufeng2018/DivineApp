package com.liuzhao.divineapp.ui.login;


import android.support.annotation.NonNull;
import android.widget.Toast;

import com.liuzhao.divineapp.base.BaseActivity;
import com.liuzhao.divineapp.data.UserRepository;
import com.liuzhao.divineapp.data.entity.UserResult;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.util.Map;

/**
 * Created by liuzhao on 2017/5/26.
 */

public class LoginPresenter implements LoginContract.Presenter {
    @NonNull
    private final LoginContract.View loginView;
    private UserRepository mUserRepository;
    private BaseActivity mContext;


    public LoginPresenter(BaseActivity mContext, UserRepository userRepository, @NonNull LoginContract.View loginView) {
        this.loginView = loginView;
        this.mContext = mContext;
        this.mUserRepository = userRepository;
        loginView.setPresenter(this);

    }

    @Override
    public void qqLogin() {
        UMShareAPI.get(mContext).getPlatformInfo(mContext, SHARE_MEDIA.QQ, umAuthListener);
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(mContext, "认证通过", Toast.LENGTH_SHORT).show();
            Log.d("umeng + QQ" + data.toString());
            UserResult userResult = new UserResult();
            userResult.setUid(data.get("uid"));
            userResult.setName(data.get("name"));
            userResult.setGender(data.get("gender"));
            userResult.setIconurl(data.get("iconurl"));
            userResult.setProvince(data.get("province"));
            userResult.setCity(data.get("city"));
            userResult.setAccesstoken(data.get("expiration"));
            mUserRepository.saveUserInfo(userResult);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "认证失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "认证取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void weixinLogin() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

}
