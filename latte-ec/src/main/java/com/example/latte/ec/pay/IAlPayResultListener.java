package com.example.latte.ec.pay;

/**
 * Created by 25400 on 2020/5/10.
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();
}
