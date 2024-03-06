package com.example.surveywithoutcompose.data

/*data class ApiResponseData(
    var Message: String? = null,
    var ErrorCode: String? = null,
    var Data: DataModel? = null)


data class DataModel(
    var responseList: List<LoginData> = arrayListOf()
)*/

data class loginDataModel(val items: List<LoginData>, val errorMessage: String)

data class LoginData(
    var objectId: String? = null,
    var createdAt: String? = null,
    var sessionToken: String? = null
)