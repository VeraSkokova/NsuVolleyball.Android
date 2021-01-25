package ru.nsu.fit.nsuvolleyball

import android.app.Application
import android.content.Context

class NsuVolleyballApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        lateinit var context: Context
    }
}