package com.xiaoyv.cultureengine.module.main.found.hot;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.callback.CultureDataCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 非遗文化 App 非遗发现数据获取
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class FoundHotModule {

    public void getFoundHot(@NonNull CultureDataCallback<FoundHotBean> callback) {

        // 此处模拟数据
        FoundHotBean foundHotBean = new FoundHotBean();
        List<FoundHotBean.FoundHot> foundHots = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            FoundHotBean.FoundHot item = new FoundHotBean.FoundHot();
            item.setLike(new Random().nextInt(500));
            if (i % 3 == 0) {
                item.setBackground("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
                item.setTitle("锄禾日当午");
                item.setName("中国梦");
                item.setHeader("http://img3.imgtn.bdimg.com/it/u=2747477288,1454412439&fm=26&gp=0.jpg");
            } else if (i % 3 == 1) {
                item.setBackground("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setTitle("唱脸谱，滦州古城");
                item.setName("梦之蓝");
                item.setHeader("http://img2.imgtn.bdimg.com/it/u=3795630848,1477575400&fm=26&gp=0.jpg");
            } else {
                item.setBackground("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
                item.setTitle("阆中古城欢迎您");
                item.setName("荆州");
                item.setHeader("http://img1.imgtn.bdimg.com/it/u=1718607933,1584052&fm=26&gp=0.jpg");
            }

            foundHots.add(item);
        }
        foundHotBean.setFoundHots(foundHots);
        callback.onCultureData(foundHotBean);
        // 此处模拟数据

    }
}
