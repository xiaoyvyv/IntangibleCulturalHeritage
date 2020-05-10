package com.xiaoyv.framework.main;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.xiaoyv.framework.BaseFragmentActivity;
import com.xiaoyv.framework.R;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainActivity extends BaseFragmentActivity<MainFragment> {

    @Override
    protected void createPresenter(MainFragment fragment) {
        new MainPresenter(fragment);
    }

    @Override
    protected MainFragment createFragment() {
        return MainFragment.newInstance();
    }


    @Override
    public void onBackPressed() {
        if (!fragment.onBackPressed()) {
            onDoubleClick();
        }
    }

    private boolean isExit = false;

    /**
     * 再按一次返回键退出
     */
    private void onDoubleClick() {
        if (!isExit) {
            isExit = true;
            ToastUtils.showShort(R.string.tips_double_exit);
            // 利用handler延迟发送更改状态信息
            Utils.runOnUiThreadDelayed(() -> isExit = false, 2000);
        } else {
            // super.onBackPressed();
            // moveTaskToBack(true);

            ActivityUtils.finishAllActivities(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            AppUtils.exitApp();
        }
    }
}
