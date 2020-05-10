package com.xiaoyv.cultureengine.module.main.home;

import androidx.annotation.NonNull;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.BaseModule;
import com.xiaoyv.cultureengine.url.Url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class BannerModule extends BaseModule {

    public void getBanner(@NonNull CultureDataCallback<BannerBean> callback) {
        OkGo.<String>get(Url.getBannerUrl()).execute(new StringCallback() {
            @Override
            public void onCacheSuccess(Response<String> response) {
                onSuccess(response);
            }

            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                BannerBean bannerBean = new BannerBean();

                Document document = Jsoup.parse(body);
                Elements elements = document.select("a.p-show");

                List<BannerBean.CultureData> cultureData = new ArrayList<>();
                for (Element element : elements) {
                    String url = Url.HOST + element.attr("href");
                    String image = Url.HOST + element.toString().substring(element.toString().indexOf("(") + 1, element.toString().lastIndexOf(")"));

                    BannerBean.CultureData banner = new BannerBean.CultureData();
                    banner.setImage(image);
                    banner.setUrl(url);
                    cultureData.add(banner);
                }
                bannerBean.setSuccessMsg();
                bannerBean.setBanner(cultureData);
                callback.onCultureData(bannerBean);
            }

            @Override
            public void onError(Response<String> response) {
                BannerBean bannerBean = new BannerBean();
                bannerBean.setErrorMsg();
                callback.onCultureData(bannerBean);
            }
        });

    }
}
