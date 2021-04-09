package com.okonur.nickgo.framework.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.okonur.nickgo.R
import com.okonur.nickgo.databinding.NickFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NickFragment : Fragment() {

    private lateinit var binding: NickFragmentBinding
    private val nickViewModel: NickViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.nick_fragment, container, false);
        binding.lifecycleOwner = this
        binding.viewmodel = nickViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueButton.setOnClickListener {
            nickViewModel.saveSession()
            findNavController().navigate(NickFragmentDirections.actionNickFragmentToChatFragment())
        }
        autoLogin()
    }

    private fun autoLogin(){
        nickViewModel.checkSessionActive()
        activity?.let { it ->
            nickViewModel.session.observe(it, {
                when {
                    it.isEmpty() -> {
                        binding.nickCircularProgressIndicator.visibility = View.GONE
                        binding.nickArea.visibility = View.VISIBLE
                    }
                    it[0].active -> {
                        findNavController().navigate(R.id.chatFragment)
                    }
                    else -> {
                        binding.nickCircularProgressIndicator.visibility = View.GONE
                        binding.nickArea.visibility = View.VISIBLE
                    }
                }
            })
        }
    }

}