package com.xiaoyv.cultureengine.module.main.mine.collection;

import androidx.annotation.NonNull;

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
public class MineCollectionModule extends BaseModule {

    public void getMineCollectionModule(MineCollectionType type, @NonNull CultureDataCallback<MineCollectionBean> callback) {
        // 此处模拟数据
        MineCollectionBean mineCollectionBean = new MineCollectionBean();
        List<MineCollectionBean.MineCollection> mineCollections = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MineCollectionBean.MineCollection item = new MineCollectionBean.MineCollection();
            item.setTimes(new Random().nextInt(5000));
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
            mineCollections.add(item);
        }
        mineCollectionBean.setMineCollections(mineCollections);
        callback.onCultureData(mineCollectionBean);
        // 此处模拟数据
    }
}
