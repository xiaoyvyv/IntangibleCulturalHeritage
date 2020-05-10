package com.xiaoyv.cultureengine.module.main.home;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class BannerBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<CultureData> banner;

    public List<BannerBean.CultureData> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean.CultureData> banner) {
        this.banner = banner;
    }

    public static class CultureData implements Serializable {
        private static final long serialVersionUID = -4263666413698000311L;
        private String image;
        private String url;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
