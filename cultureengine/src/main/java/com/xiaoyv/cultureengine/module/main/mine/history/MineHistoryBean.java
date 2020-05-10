package com.xiaoyv.cultureengine.module.main.mine.history;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineHistoryBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<MineHistory> mineHistories;

    public List<MineHistory> getMineHistories() {
        return mineHistories;
    }

    public void setMineHistories(List<MineHistory> mineHistories) {
        this.mineHistories = mineHistories;
    }

    public static class MineHistory implements Serializable {
        private static final long serialVersionUID = 5750822129749239143L;
        private String image;
        private String name;
        private String title;
        private String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
}
