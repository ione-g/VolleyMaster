package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.PlayerStats
import eone.grim.volleymaster.data.provider.PlayerStatsProvider
import eone.grim.volleymaster.databinding.FragmentPSHeightBinding
import eone.grim.volleymaster.ui.main.playerstats.collecting.utils.BasicNumberPickerAdapter

class PSHeightFragment : Fragment(),PlayerStatsProvider {

    private val binding: FragmentPSHeightBinding by lazy {
        FragmentPSHeightBinding.inflate(layoutInflater)
    }
    private var height = 180

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 4
        }

        binding.back.setOnClickListener {
            viewPager2?.currentItem = 2
        }

        val adapter = BasicNumberPickerAdapter()
        adapter.values = (110..240).toList()
        binding.heightPicker.adapter = adapter
        binding.heightPicker.itemHeight = 300
        binding.heightPicker.isCyclic = false
        binding.heightPicker.setOnValueSelectedListener{ _,pos ->
            height = adapter.values[pos]
            binding.next.visibility = View.VISIBLE
        }
        return view
    }

    override fun provideData(playerStats: PlayerStats) {
        playerStats.height = height
    }


}