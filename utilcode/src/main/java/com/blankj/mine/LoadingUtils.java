package com.blankj.mine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.R;

public class LoadingUtils {
    private static AlertDialog alertDialog = null;

    public static void showLoading(Context context) {
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) return;
            if (((Activity) context).isFinishing()) return;
            if (alertDialog == null) {
                @SuppressLint("InflateParams")
                View view = LayoutInflater.from(context).inflate(R.layout.view_loading, null, false);
                alertDialog = new AlertDialog.Builder(context, R.style.Loading_Dialog)
                        .setView(view).create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(true);
            }
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    hideLoading();
                }
            });
            alertDialog.show();
        }

    }

    public static void hideLoading() {
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }

}
