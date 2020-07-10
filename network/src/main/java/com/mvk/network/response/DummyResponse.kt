package com.mvk.network.response

import com.google.gson.annotations.SerializedName

data class DummyResponse(
    @SerializedName("statusCode")
    var statusCode: String
)