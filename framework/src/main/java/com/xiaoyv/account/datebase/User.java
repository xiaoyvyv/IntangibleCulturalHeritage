package com.xiaoyv.account.datebase;

import com.blankj.utilcode.util.TimeUtils;
import com.orm.SugarRecord;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class User extends SugarRecord {
    private String header;
    private String phone;
    private String name;
    private String password;
    private String desc;
    private String createAt;
    private String work;
    private String card;
    private String email;
    private int sex;
    private int age;

    public static User newUser(String phone, String password) {
        User user = new User();
        user.setCreateAt(TimeUtils.getNowString());
        user.setPassword(password);
        user.setPhone(phone);
        user.setName("非遗新秀");
        user.setDesc("这个人很懒，什么都没说");
        user.setWork("长江大学");
        user.setEmail("未绑定");
        user.setCard("身份证");
        user.setAge(22);
        user.setHeader("http://img4.imgtn.bdimg.com/it/u=3403496472,3338213390&fm=26&gp=0.jpg");
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
