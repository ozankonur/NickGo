package com.okonur.nickgo.framework.chat.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.model.UserModel
import com.okonur.nickgo.framework.chat.repository.Repository
import com.okonur.nickgo.framework.home.repository.SessionRepository
import com.okonur.nickgo.util.data.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
        private val repository: Repository,
        private val sessionRepository: SessionRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<MessageModel>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<MessageModel>>>
        get() = _dataState

    val userMessage = MutableLiveData("")

    fun launch() {
        viewModelScope.launch {
            repository.getChat()
                    .onEach { dataState ->
                        _dataState.value = dataState
                    }
                    .launchIn(viewModelScope)
        }
    }

    fun pushMessage() {
        viewModelScope.launch {
            userMessage.value?.let {
                MessageModel(UUID.randomUUID().toString(), it, System.currentTimeMillis(),
                        UserModel("https://www.mobilemarketingreads.com/wp-content/uploads/2020/07/meditopia-raises-15-million-758x398.png",
                                "0",
                                "Me"))
            }?.let {
                repository.pushMessage(it)
                launch()
                userMessage.value = ""
            }
        }
    }

    fun updateSessionActive(isActive : Boolean){
        viewModelScope.launch {
            sessionRepository.updateSessionActiveInfo(isActive)
        }
    }
}