package com.xiaoyv.account;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;
import com.xiaoyv.account.datebase.User;
import com.xiaoyv.account.listener.OnUserDataListener;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class UserManager {

    /**
     * @return 在线状态
     */
    public static boolean isOnline() {
        return SPUtils.getInstance("user_info").getBoolean("online");
    }

    /**
     * 设置在线状态
     *
     * @param online 在线状态
     */
    public static void setOnline(boolean online) {
        SPUtils.getInstance("user_info").put("online", online);
    }

    /**
     * @return 当前用户
     */
    public static User getCurrentUser() {
        long id = SPUtils.getInstance("user_info").getLong("online_id");
        return User.findById(User.class, id);
    }

    /**
     * 设置当前用户ID
     *
     * @param id 当前用户ID
     */
    public static void setOnlineId(long id) {
        SPUtils.getInstance("user_info").put("online_id", id);
    }

    /**
     * 注册
     */
    public static void register(User user, OnUserDataListener listener) {
        setOnline(false);
        if (user == null) {
            listener.onError("用户注册错误");
            return;
        }
        String phone = user.getPhone();
        if (StringUtils.isEmpty(phone) || phone.length() != 11) {
            listener.onError("手机号输入错误");
            return;
        }

        List<User> users = Select.from(User.class)
                .where(Condition.prop("phone").eq(phone))
                .list();

        if (ObjectUtils.isNotEmpty(users)) {
            listener.onError("用户已经存在");
            return;
        }

        String password = user.getPassword();
        if (StringUtils.isEmpty(password) || password.length() < 5) {
            listener.onError("密码需要大于6位");
            return;
        }

        String name = user.getName();
        if (StringUtils.isEmpty(name) || name.length() < 1) {
            listener.onError("昵称输入过短");
            return;
        }

        user.save();

        setOnline(true);
        listener.onSuccess();
    }

    /**
     * 登录
     */
    public static void login(String phone, String password, OnUserDataListener listener) {
        setOnline(false);
        if (StringUtils.isEmpty(phone)) {
            listener.onError("用户手机号输入为空");
            return;
        }
        if (phone.length() != 11) {
            listener.onError("手机号输入错误");
            return;
        }

        if (StringUtils.isEmpty(password)) {
            listener.onError("用户密码输入为空");
            return;
        }
        List<User> users = Select.from(User.class)
                .where(Condition.prop("phone").eq(phone))
                .list();

        if (ObjectUtils.isEmpty(users)) {
            listener.onError("用户不存在");
            return;
        }
        User user = users.get(0);
        if (!StringUtils.equals(password, user.getPassword())) {
            listener.onError("密码错误");
            return;
        }
        setOnlineId(user.getId());
        setOnline(true);
        listener.onSuccess();
    }

    public static void updateUser(User user) {
        user.update();
    }
}
