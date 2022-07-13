package com.example.colortetris.ulits

import android.content.Context

private var appContext: Context? = null

val context
    get() = appContext
        ?: error("Context missing")

fun setContext(context: Context) {
    appContext = context.applicationContext
}