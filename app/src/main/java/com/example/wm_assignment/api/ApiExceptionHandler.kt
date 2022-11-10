package com.example.wm_assignment.api

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException

object ApiExceptionHandler {
    val defaultHandler = CoroutineExceptionHandler { _, error ->
        if (error is HttpException) {
            Log.d("ErrorHandler", "network exception ${error.code()} ${error.message}")
        }
        else {
            Log.d("ErrorHandler", "exception " + error.message)
        }
    }
}