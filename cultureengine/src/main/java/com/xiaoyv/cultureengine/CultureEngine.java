package com.xiaoyv.cultureengine;

import android.app.Application;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.xiaoyv.cultureengine.http.OkHttp;

import okhttp3.OkHttpClient;


/**
 * 数据获取系统
 */
public class CultureEngine {

    /**
     * CultureEngine 框架初始化，该方法应该在自定义的 Application 中调用。
     *
     * @param application 上下文
     */
    public static void init(Application application) {
        init(application, null);
    }

    /**
     * CultureEngine 框架初始化，该方法应该在自定义的 Application 中调用。
     *
     * @param application 上下文
     * @param directory   数据缓存目录路径
     */
    public static void init(Application application, String directory) {
        // 文件缓存目录
        if (!StringUtils.isEmpty(directory)) {
            CultureEngineManager.HTTP_CACHE_DIR = directory;
        }

        OkHttpClient okHttpClient = OkHttp.getOkHttpClient(application);

        // 全局公共头，不支持中文，不允许有特殊字符
        HttpHeaders headers = new HttpHeaders();
        String userAgent = System.getProperty("http.agent");
        if (StringUtils.isEmpty(userAgent)) {
            userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/" + System.currentTimeMillis();
        }
        headers.put("User-Agent", userAgent);
        headers.put("Client", "com_yangtzeu-" + DeviceUtils.getUniqueDeviceId());



        OkGo.getInstance()
                .init(application)                                  // 必须调用初始化
                .setOkHttpClient(okHttpClient)                      // 建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)  // 全局统一缓存模式
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)       // 全局统一缓存时间，永不过期。
                .setRetryCount(2)                                   // 全局统一超时重连次数，默认为三次
                .addCommonHeaders(headers);                         // 全局公共头

    }

}










