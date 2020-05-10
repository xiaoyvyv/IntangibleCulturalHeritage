package com.xiaoyv.cultureengine.module.main.news;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App 非遗资讯数据获取
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class NewsPageModule {

    public void getNewsPage(Type type, @NonNull CultureDataCallback<NewsPageBean> callback) {

        // 此处模拟数据
        NewsPageBean newsPageBean = new NewsPageBean();
        List<NewsPageBean.NewsPage> newsPages = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            NewsPageBean.NewsPage item = new NewsPageBean.NewsPage();
            item.setTitle("模拟数据“非遗文化”：" + i);
            if (i % 3 == 0) {
                item.setBackground("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
                item.setDesc("锄禾日当午");
                item.setName("中国梦");
                item.setHeader("http://img3.imgtn.bdimg.com/it/u=2747477288,1454412439&fm=26&gp=0.jpg");
            } else if (i % 3 == 1) {
                item.setBackground("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setDesc("唱脸谱，滦州古城");
                item.setName("梦之蓝");
                item.setHeader("http://img2.imgtn.bdimg.com/it/u=3795630848,1477575400&fm=26&gp=0.jpg");
            } else {
                item.setBackground("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
                item.setDesc("阆中古城欢迎您");
                item.setName("荆州");
                item.setHeader("http://img1.imgtn.bdimg.com/it/u=1718607933,1584052&fm=26&gp=0.jpg");
            }

            newsPages.add(item);
        }
        newsPageBean.setNewsPages(newsPages);
        callback.onCultureData(newsPageBean);
        // 此处模拟数据


        switch (type) {
            case WORD:
                break;
            case DANCE:
                break;
            case SONG:
                break;
            case ART:
                break;
            case MEDICINE:
                break;
            case MUSIC:
                break;
            case DRAMA:
                break;
            case ACROBATICS:
                break;
            case SKILL:
                break;
            case FOLKORE:
                break;
            default:
                break;
        }
    }
}
