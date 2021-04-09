package com.okonur.nickgo.framework.chat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okonur.nickgo.R
import com.okonur.nickgo.databinding.ChatFragmentBinding
import com.okonur.nickgo.framework.chat.adapter.ChatAdapter
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.extension.displayError
import com.okonur.nickgo.framework.home.ui.NickFragmentDirections
import com.okonur.nickgo.util.data.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private val viewModel: ChatViewModel by viewModels()
    private lateinit var binding: ChatFragmentBinding
    private val chatAdapter = ChatAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        requireActivity()
                .onBackPressedDispatcher
                .addCallback(this) {
                    this.isEnabled = true
                    viewModel.updateSessionActive(false)
                    findNavController().navigate(ChatFragmentDirections.actionChatFragmentToNickFragment())
                }
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.chat_fragment, container, false);
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        loadChat()
        startObserve()
    }

    private fun startObserve() {
        viewModel.dataState.observe(this, { dataState ->
            when (dataState) {
                is DataState.Success<List<MessageModel>> -> {
                    binding.messageList.visibility = View.VISIBLE
                    binding.reply.visibility = View.VISIBLE
                    binding.circularProgressIndicator.visibility = View.GONE
                    chatAdapter.submitList(dataState.data)
                }
                is DataState.Error -> {
                    binding.circularProgressIndicator.visibility = View.GONE
                    displayError()
                    Timber.d(dataState.exception)
                }
                is DataState.Loading -> {
                    //We can update chat loading ui component
                }
            }
        })
    }

    private fun loadChat() {
        binding.messageList.layoutManager = LinearLayoutManager(activity)
        binding.messageList.adapter = chatAdapter
        viewModel.launch()
    }
}