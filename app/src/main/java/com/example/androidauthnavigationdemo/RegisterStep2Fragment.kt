package com.example.androidauthnavigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class RegisterStep2Fragment : Fragment() {
    private lateinit var emailInfoTextView: TextView
    private lateinit var registerButton: Button
    private val args: RegisterStep2FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_step2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailInfoTextView = view.findViewById(R.id.emailInfoTextView)
        registerButton = view.findViewById(R.id.registerButton)

        emailInfoTextView.text = "Selected email: ${args.email}"

        registerButton.setOnClickListener {
            val email = args.email

            val action = RegisterStep2FragmentDirections.actionRegisterStep2ToProfile(email)
            findNavController().navigate(action)
        }
    }
}