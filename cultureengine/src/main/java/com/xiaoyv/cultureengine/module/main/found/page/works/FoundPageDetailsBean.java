package com.xiaoyv.cultureengine.module.main.found.page.works;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗发现界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class FoundPageDetailsBean extends BaseBean {
    private static final long serialVersionUID = 916761485096543060L;
    private int attention;
    private String summary;

    private List<FoundPageDetails> foundPageDetails;

    public List<FoundPageDetails> getFoundPageDetails() {
        return foundPageDetails;
    }

    public void setFoundPageDetails(List<FoundPageDetails> foundPageDetails) {
        this.foundPageDetails = foundPageDetails;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public static class FoundPageDetails implements Serializable {
        private static final long serialVersionUID = -7553811215383975684L;
        private String background;
        private String title;
        private String time;
        private int like;


        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }
    }

}
