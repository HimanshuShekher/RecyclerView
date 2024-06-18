package com.example.assignmentapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapplication.Resource
import com.example.assignmentapplication.data.DataResponse
import com.example.assignmentapplication.network.RetrofitClient
import kotlinx.coroutines.launch

class CustomerViewModel:ViewModel() {

    private var _customerList= MutableLiveData<Resource<DataResponse>>()
    var customerList:MutableLiveData<Resource<DataResponse>> = _customerList

    fun getCustomerList(pageNo:Int, pageSize:Int,unitID:Int){
        try {
            _customerList.postValue(Resource.Loading)
            viewModelScope.launch {
                val response=RetrofitClient.api.getCustomerDetails(pageNo,pageSize,unitID)
                if (response.isSuccessful && response.body()!!.statusCode=="200"){
                    _customerList.postValue(Resource.Success(response.body()!!))
                }else{
                    _customerList.postValue(Resource.Error("Something Wrong"))
                }
            }
        }catch (e:Exception){
            _customerList.postValue(Resource.Failure(e))
        }
    }

}