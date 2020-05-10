package com.xiaoyv.cultureengine.module.main.found.hot;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗发现界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class FoundHotBean extends BaseBean {
    private static final long serialVersionUID = 8012004830643282294L;
    private List<FoundHot> foundHots;

    public List<FoundHot> getFoundHots() {
        return foundHots;
    }

    public void setFoundHots(List<FoundHot> foundHots) {
        this.foundHots = foundHots;
    }


    public static class FoundHot implements Serializable {
        private static final long serialVersionUID = 5817968483533566444L;
        private String background;
        private String name;
        private String title;
        private String header;
        private int like;

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
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

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }

}
