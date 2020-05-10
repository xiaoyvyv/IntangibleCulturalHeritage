package com.xiaoyv.framework.app;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;

import java.io.File;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/11
 */
public class AppPathManager {
    private static final String ROOT_PATH = PathUtils.getExternalAppDataPath();

    /**
     * @return App 崩溃日志路径
     */
    static String getCrashPath() {
        return getDirPath(PathUtils.getExternalAppFilesPath() + "/Crash");
    }

    /**
     * @return 图片路径
     */

    public static String getPicturePath(@Nullable String dir) {
        if (dir==null) return getDirPath(PathUtils.getExternalAppPicturesPath());
        return getDirPath(PathUtils.getExternalAppPicturesPath() + "/" + dir);
    }



    private static String getDirPath(String dirPath) {
        File file = new File(dirPath);
        FileUtils.createOrExistsDir(file);
        return file.getAbsolutePath();
    }
}
