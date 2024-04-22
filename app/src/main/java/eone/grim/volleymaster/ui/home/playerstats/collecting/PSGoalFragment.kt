package eone.grim.volleymaster.ui.home.playerstats.collecting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPSAgeBinding
import eone.grim.volleymaster.databinding.FragmentPSGoalBinding
import eone.grim.volleymaster.databinding.FragmentPSHeightBinding
import eone.grim.volleymaster.databinding.FragmentPSJumpHeightBinding
import eone.grim.volleymaster.databinding.FragmentPSVolleyLevelBinding
import eone.grim.volleymaster.ui.home.playerstats.collecting.utils.BasicNumberPickerAdapter

class PSGoalFragment : Fragment() {

    private val binding: FragmentPSGoalBinding by lazy {
        FragmentPSGoalBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.goalRG.setOnCheckedChangeListener{ _, _ ->
            binding.finish.visibility = View.VISIBLE
        }
        binding.finish.setOnClickListener {
            //TODO set on preferences to finish Collecting of User Data and push data to firebase
            collectingPlayerStatsFinished()
            findNavController().navigate(R.id.action_viewPagerFragment2_to_pagesControllerFragment)
        }

        binding.back.setOnClickListener {
            viewPager2?.currentItem = 5
        }


        return view
    }

    private fun collectingPlayerStatsFinished() {
        val sharedPref = requireActivity().getSharedPreferences("collectingPlayerStats", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}