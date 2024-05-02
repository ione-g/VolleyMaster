package eone.grim.volleymaster.ui.main.pages.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentProfileEditingBinding


class ProfileEditingFragment : Fragment() {


    val binding : FragmentProfileEditingBinding by lazy {
        FragmentProfileEditingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root

        loadUI()
        return view
    }

    private fun loadUI() {

        val genderList = arrayOf("Male","Female","Other")
        binding.genderEnter.adapter = ArrayAdapter(requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, genderList)
    }


}