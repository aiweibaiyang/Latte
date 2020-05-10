package com.example.latte.ec.pay;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;

/**
 * Created by 25400 on 2020/5/10.
 */

public class FastPay implements View.OnClickListener{

    //设置支付会回调监听
    private IAlPayResultListener mIAlPayResultListener = null;
    private Activity mActivity = null;

    private AlertDialog mDialog = null;
    private int mOrderID = -1;

    private FastPay(LatteDelegate delegate){
        this.mActivity = delegate.getProxyActivity();
        this.mDialog = new AlertDialog.Builder(delegate.getContext()).create();
    }

    public static FastPay create(LatteDelegate delegate){
        return new FastPay(delegate);
    }

    public void beginPayDialog(){
        mDialog.show();
        final Window window = mDialog.getWindow();
        if (window!=null){
            window.setContentView(R.layout.dialog_pay_pancel);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置属性
            final WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(params);

            window.findViewById(R.id.btn_dialog_pay_alpay).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_pay_wechat).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_pay_cancel).setOnClickListener(this);
        }
    }

    public FastPay setPayResultListener(IAlPayResultListener listener){
        this.mIAlPayResultListener = listener;
        return this;
    }

    public FastPay setOrderId(int orderId){
        this.mOrderID = orderId;
        return this;
    }

    public final void alPay(int orderId){
        final String singUrl = "";
        //获取签名字符串
        RestClient.builder()
                .url(singUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String paySign = "";
                        //必须是异步的调用客服端支付接口
                        final PayAsyncTask payAsyncTask = new PayAsyncTask(mActivity,mIAlPayResultListener);
                        payAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,paySign);
                    }
                })
                .build()
                .post();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_dialog_pay_alpay){
            alPay(mOrderID);
            mDialog.cancel();
        }else if(id == R.id.btn_dialog_pay_wechat){
            mDialog.cancel();
        }else if(id == R.id.btn_dialog_pay_cancel){
            mDialog.cancel();
        }
    }
}
