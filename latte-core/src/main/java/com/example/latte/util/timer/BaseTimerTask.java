package com.example.latte.util.timer;

import java.util.TimerTask;

/**
 * Created by 25400 on 2020/3/19.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener){
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
