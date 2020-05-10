package com.xiaoyv.cultureengine.module.main.found.video;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App 非遗发现界面数据
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class FoundVideoBean extends BaseBean {

    private static final long serialVersionUID = 4082261694283558100L;
    private List<FoundVideo> foundVideos;

    public List<FoundVideo> getFoundVideos() {
        return foundVideos;
    }

    public void setFoundVideos(List<FoundVideo> foundVideos) {
        this.foundVideos = foundVideos;
    }


    public static class FoundVideo implements Serializable {
        private static final long serialVersionUID = -6110152690369026403L;
        private String video;
        private String title;
        private String header;
        private String name;
        private String time;
        private int like;
        private int dislike;
        private int times;

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
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
    }

}
