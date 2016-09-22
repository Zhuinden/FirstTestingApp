package com.zhuinden.testingapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Owner on 2016.09.22.
 */

public class SecondView extends RelativeLayout {
    public SecondView(Context context) {
        super(context);
        init();
    }

    public SecondView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public SecondView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if(!isInEditMode()) {
            // ..
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
