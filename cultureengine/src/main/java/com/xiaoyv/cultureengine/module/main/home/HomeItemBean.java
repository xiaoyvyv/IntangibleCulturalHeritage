package com.xiaoyv.cultureengine.module.main.home;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 首页条目数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class HomeItemBean extends BaseBean {
    private static final long serialVersionUID = -1744516344104871076L;
    private List<HomeItem> homeItems;

    public List<HomeItem> getHomeItems() {
        return homeItems;
    }

    public void setHomeItems(List<HomeItem> homeItems) {
        this.homeItems = homeItems;
    }

    public static class HomeItem implements Serializable {
        private static final long serialVersionUID = -1935057761840442761L;
        private String background;
        private String name;
        private String desc;
        private String title;
        private String header;
        private boolean attention = false;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isAttention() {
            return attention;
        }

        public void setAttention(boolean attention) {
            this.attention = attention;
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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }
}


