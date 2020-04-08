package com.example.latte.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.latte.app.Latte;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Created by 25400 on 2020/4/7.
 */

public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //这个必须写在onCreate中
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }
}
