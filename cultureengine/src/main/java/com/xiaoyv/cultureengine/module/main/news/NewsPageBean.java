package com.xiaoyv.cultureengine.module.main.news;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗资讯界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class NewsPageBean extends BaseBean {
    private List<NewsPage> newsPages;

    public List<NewsPage> getNewsPages() {
        return newsPages;
    }

    public void setNewsPages(List<NewsPage> newsPages) {
        this.newsPages = newsPages;
    }

    private static final long serialVersionUID = 5594489038756117790L;

    public static class NewsPage implements Serializable {
        private static final long serialVersionUID = -963148788572296075L;
        private String title;
        private String background;
        private String name;
        private String desc;
        private String header;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
