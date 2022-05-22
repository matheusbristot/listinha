package com.bristot.listinha.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import javax.inject.Inject

internal class NetworkServiceImpl @Inject constructor(context: Context) : NetworkService {

    private val connectivityManager = context.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager

    override fun isConnected(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            check()
        } else {
            checkLegacy()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun check(): Boolean {
        return connectivityManager.getNetworkCapabilities(
            connectivityManager.activeNetwork
        )?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }


    @Suppress("DEPRECATION")
    private fun checkLegacy(): Boolean {
        return connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }
}