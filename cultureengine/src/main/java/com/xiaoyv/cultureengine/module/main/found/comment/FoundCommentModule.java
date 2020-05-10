package com.xiaoyv.cultureengine.module.main.found.comment;

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
public class FoundCommentModule {

    public void getFoundComment(@NonNull CultureDataCallback<FoundCommentBean> callback) {

        // 此处模拟数据
        FoundCommentBean foundCommentBean = new FoundCommentBean();
        List<FoundCommentBean.FoundComment> foundComments = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FoundCommentBean.FoundComment item = new FoundCommentBean.FoundComment();
            item.setLike(new Random().nextInt(500));
            item.setTime(TimeUtils.getNowString());
            if (i % 3 == 0) {
                item.setHeader("http://img8.zol.com.cn/bbs/upload/21615/21614045.JPG");
                item.setComment("工作认真负责，细心，任劳任怨，具有较强的学习能力，接受新事物快，理解能力强，能较好完成各种工作任务。");
                item.setName("李明");
            } else if (i % 3 == 1) {
                item.setHeader("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg");
                item.setComment("自08年进入公司以来，以极大的热情投入到工作中，并虚心向老人员学习，用较短的时间熟悉了业务操作规程，深受大家信任。");
                item.setName("张三");
            } else {
                item.setHeader("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
                item.setComment("吃苦耐劳、不怕脏、不怕累，默默承担起了维护院内各个晃特角处的卫生工作，其精神可嘉，值得大家学习。");
                item.setName("王二");
            }

            foundComments.add(item);
        }
        foundCommentBean.setFoundComments(foundComments);
        callback.onCultureData(foundCommentBean);
        // 此处模拟数据

    }
}
