package com.xiaoyv.cultureengine.module.main.found.video;

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
public class FoundVideoModule {

    public void getFoundVideo(@NonNull CultureDataCallback<FoundVideoBean> callback) {
        Random random = new Random();
        // 此处模拟数据
        FoundVideoBean foundVideoBean = new FoundVideoBean();
        List<FoundVideoBean.FoundVideo> foundVideos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FoundVideoBean.FoundVideo item = new FoundVideoBean.FoundVideo();
            item.setDislike(random.nextInt(900));
            item.setLike(random.nextInt(900));
            item.setTimes(random.nextInt(5000));
            item.setTime(TimeUtils.getNowString());

            if (i % 3 == 0) {
                item.setTitle("锄禾日当午");
                item.setName("中国梦");
                item.setHeader("http://img3.imgtn.bdimg.com/it/u=2747477288,1454412439&fm=26&gp=0.jpg");
                item.setVideo("https://zbp.toyean.com/video/zb_users/upload/imooc.mp4");
            } else if (i % 3 == 1) {
                item.setTitle("唱脸谱，滦州古城");
                item.setName("梦之蓝");
                item.setHeader("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setVideo("http://ugcyd.qq.com/uwMROfz2r57EIaQXGdGnC2ddDmY0gCKxs_YQn4ev8GMVk_hh/shg_24517576_50001_7cfff0d4abd63500b788738cee1e0cb4.f622.mp4?vkey=16C8F5DC64863BA58262C0AFCF9E07A210ACDAE19B378555B6C933F687D80327DB7D2E8E6533BF65E88F7CA386BAB186B7C848175B77BF51595DBD03481216501A5FA35A309E4F105D58AD0A5AC5CFA1B6945704BBC7F771156DC5D8BEC8132BFAC9E91DC6714AFFA783BBF8E4EDD459BA4487D130F9179878975F04BA3AA920&br=44&platform=2&fmt=auto&level=0&sdtfrom=v5010&guid=755a2d9588bf75109bd29a3bf1edb545");
            } else {
                item.setTitle("阆中古城欢迎您");
                item.setName("荆州");
                item.setHeader("http://img1.imgtn.bdimg.com/it/u=1718607933,1584052&fm=26&gp=0.jpg");
                item.setVideo("https://1400329073.vod2.myqcloud.com/d62d88a7vodtranscq1400329073/0f02d4155285890799710670616/mix_10_3.m3u8");
            }

            foundVideos.add(item);
        }
        foundVideoBean.setFoundVideos(foundVideos);
        callback.onCultureData(foundVideoBean);
        // 此处模拟数据

    }
}
