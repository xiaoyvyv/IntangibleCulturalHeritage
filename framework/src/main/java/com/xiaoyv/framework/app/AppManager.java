package com.xiaoyv.framework.app;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.dueeeke.videoplayer.ijk.IjkPlayerFactory;
import com.dueeeke.videoplayer.player.AndroidMediaPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.xiaoyv.cultureengine.CultureEngine;

class AppManager {

    /**
     * 检测是否为主进程
     */
    static boolean checkMainProcess(Application app) {
        String processName = ProcessUtils.getCurrentProcessName();
        return StringUtils.equals(app.getPackageName(), processName);
    }

    /**
     * 安装 软件崩溃拦截
     */
    static void initCRASH(Application app) {
        if (ContextCompat.checkSelfPermission(app, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        CrashUtils.init(AppPathManager.getCrashPath(), (crashInfo, e) -> {
            //TODO App 崩溃处理
            e.printStackTrace();
        });
    }


    /**
     * 安装 AndroidUtils
     */
    static void initUtils(Application app) {
        Utils.init(app);
    }

    /**
     * 安装 X5内核
     */
    static void initX5(Application app) {
        // X5InitService.start(app);
    }

    /**
     * 安装 文化数据引擎
     */
    static void initCULTURE(Application app) {
        CultureEngine.init(app, PathUtils.getExternalAppCachePath());
    }

    /**
     * 安装 第三方播放器
     */
    static void initVIDEO() {
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                // 使用使用IjkPlayer解码
                .setPlayerFactory(IjkPlayerFactory.create())
                // 使用ExoPlayer解码
                // .setPlayerFactory(ExoMediaPlayerFactory.create())
                // 使用MediaPlayer解码
                // .setPlayerFactory(AndroidMediaPlayerFactory.create())
                .build());
    }
}
