package com.xiaoyv.cultureengine.module.main.mine.dynamic;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineDynamicBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<MineDynamic> mineDynamics;

    public List<MineDynamic> getMineDynamics() {
        return mineDynamics;
    }

    public void setMineDynamics(List<MineDynamic> mineDynamics) {
        this.mineDynamics = mineDynamics;
    }

    public static class MineDynamic implements Serializable {
        private static final long serialVersionUID = 5750822129749239143L;
        private String header;
        private String content;
        private String name;
        private String time;
        private String image;
        private int like;
        private int dislike;
        private int comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getDislike() {
            return dislike;
        }

        public void setDislike(int dislike) {
            this.dislike = dislike;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }
    }
}
