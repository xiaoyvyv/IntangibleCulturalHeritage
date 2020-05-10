package com.xiaoyv.cultureengine.module.main.make;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗发现界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class MineMakeBean extends BaseBean {
    private static final long serialVersionUID = 1329175031824897842L;
    private List<MineMake> mineMakes;

    public List<MineMake> getMineMakes() {
        return mineMakes;
    }

    public void setMineMakes(List<MineMake> mineMakes) {
        this.mineMakes = mineMakes;
    }

    public static class MineMake implements Serializable {
        private static final long serialVersionUID = 8393100933297612371L;
        private String header;
        private String name;
        private String time;
        private String comment;
        private int like;

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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }
    }

}
