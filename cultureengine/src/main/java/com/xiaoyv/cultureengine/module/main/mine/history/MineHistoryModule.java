package com.xiaoyv.cultureengine.module.main.mine.history;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.TimeUtils;
import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.BaseModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineHistoryModule extends BaseModule {

    public void getMineHistoryModule(MineHistoryType type, @NonNull CultureDataCallback<MineHistoryBean> callback) {
        // 此处模拟数据
        MineHistoryBean mineHistoryBean = new MineHistoryBean();
        List<MineHistoryBean.MineHistory> mineHistories = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MineHistoryBean.MineHistory item = new MineHistoryBean.MineHistory();
            item.setTime(TimeUtils.getNowString());
            if (i % 3 == 0) {
                item.setName("中国梦");
                item.setTitle("小呀嘛小二郎");
                item.setImage("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
            } else if (i % 3 == 1) {
                item.setName("梦之蓝");
                item.setTitle("背着书包上学堂");
                item.setImage("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
            } else {
                item.setName("荆州");
                item.setTitle("太阳出来罗喂");
                item.setImage("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
            }
            mineHistories.add(item);
        }
        mineHistoryBean.setMineHistories(mineHistories);
        callback.onCultureData(mineHistoryBean);
        // 此处模拟数据
    }
}
