package com.example.myapplication

import okhttp3.OkHttpClient
import okhttp3.Request

object Client {

    private val okHttpClient = OkHttpClient()
    private val request = Request.Builder()
        .url("https://api.covid19india.org/data.json").build()

    val api= okHttpClient.newCall(request)


    private val request1 = Request.Builder()
        .url("https://api.opencovid.ca/summary?loc=prov").build()

    val api1= okHttpClient.newCall(request1)

    private val requeststate = Request.Builder()
        .url("https://api.covid19tracker.ca/summary").build()

    val api2= okHttpClient.newCall(requeststate)
}