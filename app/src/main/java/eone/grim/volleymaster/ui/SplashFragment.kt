package eone.grim.volleymaster.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import eone.grim.volleymaster.MainActivity
import eone.grim.volleymaster.R
import eone.grim.volleymaster.ui.auth.login.LoginActivity
import eone.grim.volleymaster.viewmodels.TrainingViewModel


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardingFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_authStartPage)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }},1000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun loadData() {
        ViewModelProvider(requireActivity())[TrainingViewModel::class.java]

    }

    private fun onBoardingFinished():Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
}