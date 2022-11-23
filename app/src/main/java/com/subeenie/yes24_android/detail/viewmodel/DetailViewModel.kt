package com.subeenie.yes24_android.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel(){
    var count = 0

    private val _posterExpand = MutableLiveData<Boolean>(false)
    val posterExpand :LiveData<Boolean> get() = _posterExpand

    private val _detailExpand = MutableLiveData<Boolean>(false)
    val detailExpand :LiveData<Boolean> get() = _detailExpand

    fun onExpandClick(num : Int){
        if(num == 1){
            _posterExpand.value = !(_posterExpand.value)!!
        }else{
            _detailExpand.value = !(_detailExpand.value)!!
        }
    }

}