package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.PlayerStats
import eone.grim.volleymaster.data.provider.PlayerStatsProvider
import eone.grim.volleymaster.databinding.FragmentPSVolleyLevelBinding

class PSVolleyLevelFragment : Fragment(), PlayerStatsProvider {

    private lateinit var volleyLevel: Number
    private val binding: FragmentPSVolleyLevelBinding by lazy {
        FragmentPSVolleyLevelBinding.inflate(layoutInflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 6
        }

        binding.back.setOnClickListener {
            viewPager2?.currentItem = 4
        }
        binding.levelRG.setOnCheckedChangeListener{ group, id ->
            volleyLevel = group.indexOfChild(group.findViewById<RadioButton>(id))
            binding.next.visibility = View.VISIBLE
        }
        return view
    }

    override fun provideData(playerStats: PlayerStats) {
        playerStats.volleyLevel = volleyLevel
    }


}