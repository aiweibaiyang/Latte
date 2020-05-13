package com.example.latte.ui.camera;

import android.net.Uri;

import com.example.latte.delegates.PermissionCheckerDelegate;
import com.example.latte.util.file.FileUtil;

/**
 * Created by 25400 on 2020/5/12.
 * 照相机调用类
 */


public class LatteCamera {

    public static Uri createCropFile(){
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG","jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate){
        new CameraHandler(delegate).beginCameraDialog();
    }
}
