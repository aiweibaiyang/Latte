package com.festec.example;


import android.app.Application;

import com.example.festec.R;
import com.example.latte.app.Latte;
import com.festec.example.event.TestEvent;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by 25400 on 2020/2/26.
 */

public class exampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
//                .withApiHost("http://127.0.0.1:8081/RestServer/api/")
                .withApiHost("http://192.168.155.2:8081/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .withJavascriptInterface("latte")
                .withWebEvent("test",new TestEvent())
                .configure();
//        initStetho();
        DatabaseManager.getInstance().init(this);
    }

//    private void initStetho(){
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                .build()
//        );
//    }
}
