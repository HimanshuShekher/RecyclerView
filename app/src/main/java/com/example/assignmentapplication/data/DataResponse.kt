package com.example.assignmentapplication.data


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("responseData")
    val responseData: List<ResponseData>,
    @SerializedName("responseData1")
    val responseData1: ResponseData1,
    @SerializedName("statusCode")
    val statusCode: String, // 200
    @SerializedName("statusMessage")
    val statusMessage: String // Completed_GetAllData_Successfully
) {
    data class ResponseData(
        @SerializedName("customerId")
        val customerId: Int, // 11
        @SerializedName("fName")
        val fName: String, // Akshay
        @SerializedName("isBuffalo")
        val isBuffalo: Int, // 1
        @SerializedName("isCow")
        val isCow: Int, // 1
        @SerializedName("lName")
        val lName: String, // Gavali
        @SerializedName("mName")
        val mName: Any, // null
        @SerializedName("mobileNo")
        val mobileNo: String, // 8750000000
        @SerializedName("rfName")
        val rfName: Any, // null
        @SerializedName("rlName")
        val rlName: Any, // null
        @SerializedName("rmName")
        val rmName: Any // null
    )

    data class ResponseData1(
        @SerializedName("pageCount")
        val pageCount: Int, // 21
        @SerializedName("pageNo")
        val pageNo: Int, // 1
        @SerializedName("totalPages")
        val totalPages: Int // 3
    )
}