package com.vientamthuong.learning_16.behavior;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class FirstBehavior extends CoordinatorLayout.Behavior<TextView> {

    public FirstBehavior() {
    }

    public FirstBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
