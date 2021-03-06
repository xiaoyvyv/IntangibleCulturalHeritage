package com.xiaoyv.cultureengine.http;

import android.content.Context;

import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;


public class OkHttp {
    private volatile static OkHttpClient okHttpClient;
    private volatile static CookieJarImpl cookieJar;

    /**
     * 获取Cookie管理器
     */
    public static CookieJarImpl getCookieJar(Context context) {
        if (cookieJar == null) {
            synchronized (CookieJarImpl.class) {
                if (cookieJar == null) {
                    cookieJar = new CookieJarImpl(new DBCookieStore(context));
                }
            }
        }
        return cookieJar;
    }

    /**
     * 获取自定义OkHttpClient
     */
    public static OkHttpClient getOkHttpClient(Context context) {
        CookieJarImpl cookieJar = OkHttp.getCookieJar(context);
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    // 信任所有证书,不安全有风险
                    HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();

                    // 日志打印颜色
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("EduEngineOkGo");
                    loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
                    loggingInterceptor.setColorLevel(Level.INFO);

                    // 构建OkHttpClient
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.proxy(Proxy.NO_PROXY);
                    builder.addInterceptor(loggingInterceptor);
                    builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
                    builder.connectTimeout(5, TimeUnit.SECONDS);
                    builder.readTimeout(20, TimeUnit.SECONDS);
                    builder.writeTimeout(5 * 60, TimeUnit.SECONDS);
                    builder.cookieJar(cookieJar);
                    okHttpClient = builder.build();
                }
            }
        }
        return okHttpClient;
    }

}
