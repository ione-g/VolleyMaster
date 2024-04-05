package eone.grim.volleymaster.ui.onboard

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentSixthOnBoardScreenBinding
import eone.grim.volleymaster.ui.auth.login.LoginActivity


class SixthOnBoardScreen : Fragment() {

    private val binding : FragmentSixthOnBoardScreenBinding by lazy {
        FragmentSixthOnBoardScreenBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val textView = binding.textView
        val tvStr:Spannable = SpannableString(resources.getString(R.string.we_love_our_users_become_one_of_them_now))
        tvStr.setSpan(ForegroundColorSpan(Color.parseColor("#E2B56E")),0,tvStr.length-5,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvStr.setSpan(ForegroundColorSpan(Color.parseColor("#866000")),tvStr.length-5,tvStr.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = tvStr

        binding.nextPage.setOnClickListener {
            onBoardingFinished()
            findNavController().navigate(R.id.action_viewPagerFragment_to_authStartPage)
//            startActivity(Intent(activity, LoginActivity::class.java))
        }

        return view

    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}