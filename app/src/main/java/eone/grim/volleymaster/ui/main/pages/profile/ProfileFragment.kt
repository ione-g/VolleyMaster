package eone.grim.volleymaster.ui.main.pages.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {



    val binding : FragmentProfileBinding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root
        binding.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_profileEditing)
        }
        return view
    }


}