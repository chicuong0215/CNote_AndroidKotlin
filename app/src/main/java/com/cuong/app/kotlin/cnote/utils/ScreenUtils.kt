package com.cuong.app.kotlin.cnote.utils

import android.view.Window
import android.view.WindowManager

class ScreenUtils() {
    fun setFullScreen(window: Window) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}