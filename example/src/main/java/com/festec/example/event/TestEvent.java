package com.festec.example.event;


import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.latte.delegates.web.event.Event;
import com.orhanobut.logger.Logger;


/**
 * Created by 25400 on 2020/5/3.
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(),getAction(),Toast.LENGTH_LONG).show();
        if (getAction().equals("test")){
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", null);
                }
            });
        }
        return null;
    }
}
