package com.example.surveywithoutcompose.data

import android.content.Context
import com.example.surveywithoutcompose.util.ApiStatus
import com.example.surveywithoutcompose.util.Constants
import com.example.surveywithoutcompose.util.NetworkResult
import com.example.surveywithoutcompose.util.Utils
import kotlin.reflect.full.memberProperties

class ApiResultHandler<T>(
    private val context: Context, private val onLoading: () -> Unit,
    private val onSuccess: (T?) -> Unit, private val onFailure: (T?) -> Unit
) {

    fun handleApiResult(result: NetworkResult<T?>) {
        when (result.status) {
            ApiStatus.LOADING -> {
                onLoading()
            }

            ApiStatus.SUCCESS -> {
                onSuccess(result.data)
            }

            ApiStatus.ERROR -> {
                onFailure(result.data)
                when (result.data?.getField<String>("ErrorCode") ?: "0") {
                    Constants.API_FAILURE_CODE -> {
                        Utils.showAlertDialog(context, result.message.toString())
                    }
                    Constants.API_INTERNET_CODE -> {
                        Utils.showAlertDialog(context, Constants.API_INTERNET_MESSAGE)
                    }
                    else -> {
                        Utils.showAlertDialog(context, Constants.API_SOMETHING_WENT_WRONG_MESSAGE)
                    }
                }
            }
        }
    }

    @Throws(IllegalAccessException::class, ClassCastException::class)
    inline fun <reified T> Any.getField(fieldName: String): T? {
        this::class.memberProperties.forEach { kCallable ->
            if (fieldName == kCallable.name) {
                return kCallable.getter.call(this) as T?
            }
        }
        return null
    }

}


