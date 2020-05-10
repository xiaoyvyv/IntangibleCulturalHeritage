package com.xiaoyv.cultureengine.module.main.found.page.works;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.TimeUtils;
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
public class FoundPageDetailsModule {

    public void getPageDetailsModule(@NonNull CultureDataCallback<FoundPageDetailsBean> callback) {

        // 此处模拟数据
        FoundPageDetailsBean foundPageDetailsBean = new FoundPageDetailsBean();
        List<FoundPageDetailsBean.FoundPageDetails> foundPageDetails = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FoundPageDetailsBean.FoundPageDetails item = new FoundPageDetailsBean.FoundPageDetails();
            item.setLike(new Random().nextInt(500));
            item.setTime(TimeUtils.getNowString());
            if (i % 3 == 0) {
                item.setBackground("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
                item.setTitle("安塞腰鼓");
            } else if (i % 3 == 1) {
                item.setBackground("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setTitle("泼水节");
            } else {
                item.setBackground("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
                item.setTitle("火把节");
            }

            foundPageDetails.add(item);
        }
        foundPageDetailsBean.setFoundPageDetails(foundPageDetails);
        callback.onCultureData(foundPageDetailsBean);
        // 此处模拟数据

    }
}
