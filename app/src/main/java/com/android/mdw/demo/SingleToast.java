package com.android.mdw.demo;

import android.content.Context;
import android.widget.Toast;

public class SingleToast {

    private static Toast mToast;

    public static void show(Context context, String text, int duration) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, text, duration);
        mToast.show();
        sleep();

    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

