package com.okonur.nickgo.framework.home.ui

import androidx.lifecycle.*
import com.okonur.nickgo.framework.home.Validator
import com.okonur.nickgo.framework.home.data.model.SessionModel
import com.okonur.nickgo.framework.home.repository.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NickViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) : ViewModel() {

    private val _session: MutableLiveData<List<SessionModel>> = MutableLiveData()

    val session: LiveData<List<SessionModel>>
        get() = _session

    val nickName = MutableLiveData("")
    val isValidNick = MediatorLiveData<Boolean>().apply {
        addSource(nickName) {
            value = Validator().isNickNameValid(it)
        }
    }

    fun saveSession() {
        viewModelScope.launch {
            sessionRepository.insertSession(
                SessionModel(
                    session = "0",
                    timestamp = System.currentTimeMillis(),
                    active = true
                )
            )
        }
    }


    fun checkSessionActive(){
        viewModelScope.launch {
            sessionRepository.getSession().collect {
                _session.value = it
            }
        }
    }
}