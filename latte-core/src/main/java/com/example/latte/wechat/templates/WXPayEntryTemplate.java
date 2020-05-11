package com.example.latte.wechat.templates;

import android.widget.Toast;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.wechat.BaseWXActivity;
import com.example.latte.wechat.BaseWXPayEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/**
 * Created by 25400 on 2020/4/6.
 */

public class WXPayEntryTemplate extends BaseWXPayEntryActivity {

    @Override
    protected void onPaySuccess() {
        Toast.makeText(this,"支付成功",Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onPayFail() {
        Toast.makeText(this,"支付失败",Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onPayCancel() {
        Toast.makeText(this,"支付取消",Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    public void onReq(BaseReq baseReq) {
    }

    @Override
    public void onResp(BaseResp baseResp) {

    }
}
