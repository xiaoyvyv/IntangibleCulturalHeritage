package com.xiaoyv.cultureengine.module.main.mine.message;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.TimeUtils;
import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.BaseModule;
import com.xiaoyv.cultureengine.module.main.found.video.FoundVideoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineMessageModule extends BaseModule {

    public void getMineMessage(MineMessageType type, @NonNull CultureDataCallback<MineMessageBean> callback) {

        // 此处模拟数据
        MineMessageBean mineMessageBean = new MineMessageBean();
        List<MineMessageBean.MineMessage> mineMessages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MineMessageBean.MineMessage item = new MineMessageBean.MineMessage();
            item.setTime(TimeUtils.getNowString());

            if (i % 3 == 0) {
                item.setTitle(type.name() + "：锄禾日当午");
                item.setName("中国梦");
                item.setHeader("http://img3.imgtn.bdimg.com/it/u=2747477288,1454412439&fm=26&gp=0.jpg");
            } else if (i % 3 == 1) {
                item.setTitle(type.name() + "：唱脸谱，滦州古城");
                item.setName("梦之蓝");
                item.setHeader("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
            } else {
                item.setTitle(type.name() + "：阆中古城欢迎您");
                item.setName("荆州");
                item.setHeader("http://img1.imgtn.bdimg.com/it/u=1718607933,1584052&fm=26&gp=0.jpg");
            }
            mineMessages.add(item);
        }
        mineMessageBean.setMineMessages(mineMessages);
        callback.onCultureData(mineMessageBean);
        // 此处模拟数据
    }
}
