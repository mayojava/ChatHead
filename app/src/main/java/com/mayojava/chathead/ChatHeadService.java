package com.mayojava.chathead;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mayowa on 14/01/2017.
 */

public class ChatHeadService extends Service {
    private WindowManager mWindowManager;
    private View mChatView;

    public ChatHeadService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //inflate the chat head layout
        mChatView = LayoutInflater.from(this)
                .inflate(R.layout.layout_chat_head, null);

        //Add the view to the window
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        /**
         * specify the chat head position. Initially view will be added to top-left corner
         */

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mChatView, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mChatView != null) {
            mWindowManager.removeView(mChatView);
        }
    }
}
