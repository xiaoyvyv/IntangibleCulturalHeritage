package com.xiaoyv.cultureengine.module.main.found.page;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗发现界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class FoundPageBean extends BaseBean {
    private static final long serialVersionUID = 916761485096543060L;
    private List<FoundPage> foundPages;

    public List<FoundPage> getFoundPages() {
        return foundPages;
    }

    public void setFoundPages(List<FoundPage> foundPages) {
        this.foundPages = foundPages;
    }


    public static class FoundPage implements Serializable {
        private static final long serialVersionUID = -7553811215383975684L;
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
