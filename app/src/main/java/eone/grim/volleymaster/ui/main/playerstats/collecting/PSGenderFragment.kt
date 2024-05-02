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
import eone.grim.volleymaster.databinding.FragmentPSGenderBinding


class PSGenderFragment : Fragment(), PlayerStatsProvider {
    private val binding : FragmentPSGenderBinding by lazy {
        FragmentPSGenderBinding.inflate(layoutInflater)
    }

    private lateinit var gender: Number

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root
        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 1
        }
        setRadioGroup()


        return view
    }


    private fun setRadioGroup() {
        val maleBtn = binding.maleRadioBtn
        val femaleBtn = binding.femaleRadioBtn
        val otherBtn = binding.otherRadioBtn

        maleBtn.setOnClickListener{
            binding.next.visibility = View.VISIBLE
            gender = 0
            femaleBtn.isChecked = false
            otherBtn.isChecked = false

        }
        femaleBtn.setOnClickListener{
            binding.next.visibility = View.VISIBLE
            gender = 1
            maleBtn.isChecked = false
            otherBtn.isChecked = false

        }
        otherBtn.setOnClickListener{
            binding.next.visibility = View.VISIBLE
            gender = 2
            femaleBtn.isChecked = false
            maleBtn.isChecked = false

        }
    }

    override fun provideData(playerStats: PlayerStats) {
        playerStats.gender = gender
    }
}