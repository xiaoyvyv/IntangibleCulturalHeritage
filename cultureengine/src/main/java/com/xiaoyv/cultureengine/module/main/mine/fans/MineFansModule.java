package com.xiaoyv.cultureengine.module.main.mine.fans;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.TimeUtils;
import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.BaseModule;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineFansModule extends BaseModule {

    public void getMineFans(@NonNull CultureDataCallback<MineFansBean> callback) {

        // 此处模拟数据
        MineFansBean mineFansBean = new MineFansBean();
        List<MineFansBean.MineFans> mineFans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MineFansBean.MineFans item = new MineFansBean.MineFans();
            item.setTime(TimeUtils.getNowString());

            if (i % 3 == 0) {
                item.setAttention(true);
                item.setName("中国梦");
                item.setDesc("丹凤眼斑竹岭边无限泪");
                item.setHeader("http://img3.imgtn.bdimg.com/it/u=2747477288,1454412439&fm=26&gp=0.jpg");
            } else if (i % 3 == 1) {
                item.setAttention(false);
                item.setName("梦之蓝");
                item.setDesc("克苏鲁之眼");
                item.setHeader("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
            } else {
                item.setName("荆州");
                item.setAttention(true);
                item.setDesc("东风不与周郎便");
                item.setHeader("http://img1.imgtn.bdimg.com/it/u=1718607933,1584052&fm=26&gp=0.jpg");
            }
            mineFans.add(item);
        }
        mineFansBean.setMineFans(mineFans);
        callback.onCultureData(mineFansBean);
        // 此处模拟数据
    }
}
