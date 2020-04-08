package com.example.latte.wechat.templates;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.wechat.BaseWXEntryActivity;
import com.example.latte.wechat.LatteWeChat;

/**
 * Created by 25400 on 2020/4/6.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
