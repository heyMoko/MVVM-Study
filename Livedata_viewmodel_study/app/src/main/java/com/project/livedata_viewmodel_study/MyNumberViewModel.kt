package com.project.livedata_viewmodel_study

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 데이터의 변경을 가짐
// 데이터의 변경사항을 알려주는 라이브데이터를 가짐
class MyNumberViewModel: ViewModel() {

    companion object {
        const val TAG: String = "로그"
    }

    val currentValue: LiveData<Int>
        get() = _currentValue

    private val _currentValue = MutableLiveData<Int>()

    // 초기값 세팅
    init {
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input: Int) {
        when (actionType) {
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }

}

enum class ActionType {

    PLUS, MINUS

}