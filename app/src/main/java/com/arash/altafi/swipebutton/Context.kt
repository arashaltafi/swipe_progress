package com.arash.altafi.swipebutton

import android.annotation.SuppressLint
import android.util.Log

@SuppressLint("LogNotTimber")
fun Any.logE(tag: String = "", throwable: Throwable? = null) {
        Log.e(tag, "$this\n", throwable)
}

@SuppressLint("LogNotTimber")
fun Any.logI(tag: String = "", throwable: Throwable? = null) {
        Log.i("nExt -> $tag", "$this\n", throwable)
}

@SuppressLint("LogNotTimber")
fun Any.logD(tag: String = "", throwable: Throwable? = null) {
        Log.d(tag, "$this\n", throwable)
}