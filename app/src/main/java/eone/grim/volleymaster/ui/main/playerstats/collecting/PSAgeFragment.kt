package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.PlayerStats
import eone.grim.volleymaster.data.provider.PlayerStatsProvider
import eone.grim.volleymaster.databinding.FragmentPSAgeBinding
import eone.grim.volleymaster.ui.main.playerstats.collecting.utils.BasicNumberPickerAdapter


class PSAgeFragment : Fragment(),PlayerStatsProvider {

    private val binding: FragmentPSAgeBinding by lazy {
        FragmentPSAgeBinding.inflate(layoutInflater)
    }
    private lateinit var age: Number

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 2
        }
        binding.back.setOnClickListener {
            viewPager2?.currentItem = 0
        }

        val adapter = BasicNumberPickerAdapter()
        adapter.values = (0..100).toList()
        binding.agePicker.adapter = adapter
        binding.agePicker.itemHeight = 300
        binding.agePicker.isCyclic = false
        binding.agePicker.setOnValueSelectedListener{ valueView,value ->
            binding.next.visibility = View.VISIBLE
            age = value
        }
        return view
    }

    override fun provideData(playerStats: PlayerStats) {
        playerStats.age = age
    }

}

