package com.example.android_query_cookbook_kotlin

import android.app.Application
import com.example.android_query_cookbook_kotlin.R
import com.parse.Parse

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .enableLocalDataStore()
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

    }


}