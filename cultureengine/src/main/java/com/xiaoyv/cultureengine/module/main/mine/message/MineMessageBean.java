package com.xiaoyv.cultureengine.module.main.mine.message;

import com.xiaoyv.cultureengine.module.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MineMessageBean extends BaseBean {
    private static final long serialVersionUID = -5715406895511205279L;

    private List<MineMessage> mineMessages;

    public List<MineMessage> getMineMessages() {
        return mineMessages;
    }

    public void setMineMessages(List<MineMessage> mineMessages) {
        this.mineMessages = mineMessages;
    }

    public static class MineMessage implements Serializable {
        private static final long serialVersionUID = 5750822129749239143L;
        private String header;
        private String name;
        private String title;
        private String time;

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
    }
}
