package com.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.festec.R;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.ISuccess;

/**
 * Created by 25400 on 2020/3/3.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private void testRestClient(){
        RestClient.builder()
                .url("")
                .params("","")
                .success(new ISuccess() {
                    @Override
                    public void OnSuccess(String response) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build();
    }
}
