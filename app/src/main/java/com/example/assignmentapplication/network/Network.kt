package com.example.assignmentapplication.network

import com.example.assignmentapplication.data.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Network {
    @GET("api/CustomerDetails/GetCustomerDetails")
    suspend fun getCustomerDetails(@Query("pageno") pageno:Int, @Query("pagesize") pagesize:Int, @Query("UnitId") UnitId:Int): Response<DataResponse>
}