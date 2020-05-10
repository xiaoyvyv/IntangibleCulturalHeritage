package com.xiaoyv.cultureengine.module.main.mine.collection;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineCollectionBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<MineCollection> mineCollections;

    public List<MineCollection> getMineCollections() {
        return mineCollections;
    }

    public void setMineCollections(List<MineCollection> mineCollections) {
        this.mineCollections = mineCollections;
    }

    public static class MineCollection implements Serializable {
        private static final long serialVersionUID = 5750822129749239143L;
        private String image;
        private String name;
        private String title;
        private int times;

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

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }
}
