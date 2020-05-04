package com.example.latte.delegates.web.event;

import com.example.latte.util.log.LatteLogger;

/**
 * Created by 25400 on 2020/5/3.
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent",params);
        return null;
    }
}
