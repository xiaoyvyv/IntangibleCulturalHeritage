package com.xiaoyv.cultureengine.module.main.mine.fans;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineFansBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<MineFans> mineFans;

    public List<MineFans> getMineFans() {
        return mineFans;
    }

    public void setMineFans(List<MineFans> mineFans) {
        this.mineFans = mineFans;
    }

    public static class MineFans implements Serializable {
        private static final long serialVersionUID = 5750822129749239143L;
        private String header;
        private String name;
        private String desc;
        private String time;
        private boolean attention;

        public boolean isAttention() {
            return attention;
        }

        public void setAttention(boolean attention) {
            this.attention = attention;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
