package com.example.surveywithoutcompose.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.surveywithoutcompose.MyApplication
import com.example.surveywithoutcompose.data.UserRequest
import com.example.surveywithoutcompose.databinding.FragmentWelcomeBinding
import com.example.surveywithoutcompose.util.Utils
import com.example.surveywithoutcompose.util.Utils.isEmailValid
import com.example.surveywithoutcompose.viewModels.Welcome_VM
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWelcomeBinding
    private val welcome_VM by viewModels<Welcome_VM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        _binding.lifecycleOwner = this
        _binding.welcomeBinding = this
        return _binding.root
    }


    fun onClickButtom(user_welcome: Boolean) {
//        val sigIn_Data = UserRequest("zxzx@.com", "111111", "zxzx@.com")
        var email = _binding.emailText.text.toString()
        if (isEmailValid(email)) {
            if (user_welcome) {
                // Move another fragment with email
                val emailSend = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment2(email)
                findNavController().navigate(emailSend)
            } else {
                //For Main Page by Guest
            }
        }else{
            if (email=="") Toast.makeText(this@WelcomeFragment.requireActivity(), "Email Not Valid", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this@WelcomeFragment.requireActivity(), "$email Not Valid", Toast.LENGTH_SHORT).show()
        }
    }
}