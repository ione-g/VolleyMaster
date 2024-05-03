package eone.grim.volleymaster.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentAuthStartPageBinding
import eone.grim.volleymaster.ui.auth.register.RegisterActivity
import eone.grim.volleymaster.ui.main.PagesActivity


class AuthStartPage : Fragment() {

    private val binding : FragmentAuthStartPageBinding by lazy {
        FragmentAuthStartPageBinding.inflate(layoutInflater)
    }
    private val auth : FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root
        if (isAuthenticated()) {
            startActivity(Intent(activity, PagesActivity::class.java))
            activity?.finish()
            return inflater.inflate(R.layout.fragment_splash, container, false)
        }
        //TODO implement google sign in
        binding.signInGoogle.setOnClickListener {
            startActivity(Intent(activity,RegisterActivity::class.java))
        }

        binding.signInOther.setOnClickListener {
            startActivity(Intent(activity,RegisterActivity::class.java))
        }

        return view
    }

    private fun isAuthenticated() : Boolean {
        return auth.currentUser != null
    }

}