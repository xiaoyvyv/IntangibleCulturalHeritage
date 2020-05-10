package com.xiaoyv.cultureengine.module.holl;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class HallBean extends BaseBean {
    private static final long serialVersionUID = -2785624436433770116L;

    private List<HallData> holl;

    public List<HallData> getHoll() {
        return holl;
    }

    public void setHoll(List<HallData> holl) {
        this.holl = holl;
    }

    public static class HallData implements Serializable {
        private static final long serialVersionUID = -4704976794600217493L;
        private String title;
        private String local;
        private String content;
        private String image;
        private String imageTip;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLocal() {
            return local;
        }

        public void setLocal(String local) {
            this.local = local;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImageTip() {
            return imageTip;
        }

        public void setImageTip(String imageTip) {
            this.imageTip = imageTip;
        }
    }

}
