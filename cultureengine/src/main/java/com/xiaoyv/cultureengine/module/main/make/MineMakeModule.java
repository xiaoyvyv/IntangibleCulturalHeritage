package com.xiaoyv.cultureengine.module.main.make;

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
public class MineMakeModule {

    public void getMineMakeModule(@NonNull CultureDataCallback<MineMakeBean> callback) {

        // 此处模拟数据
        MineMakeBean mineMakeBean = new MineMakeBean();
        List<MineMakeBean.MineMake> mineMakes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MineMakeBean.MineMake item = new MineMakeBean.MineMake();
            item.setLike(new Random().nextInt(500));
            item.setTime(TimeUtils.getNowString());
            if (i % 3 == 0) {
                item.setHeader("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
                item.setComment("工作认真负责，细心，任劳任怨，具有较强的学习能力。");
                item.setName("李明");
            } else if (i % 3 == 1) {
                item.setHeader("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setComment("用较短的时间熟悉了业务操作规程，深受大家信任。");
                item.setName("张三");
            } else {
                item.setHeader("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
                item.setComment("其精神可嘉，值得大家学习。");
                item.setName("王二");
            }

            mineMakes.add(item);
        }
        mineMakeBean.setMineMakes(mineMakes);
        callback.onCultureData(mineMakeBean);
        // 此处模拟数据

    }
}
