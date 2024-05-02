package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.PlayerStats
import eone.grim.volleymaster.data.provider.PlayerStatsProvider
import eone.grim.volleymaster.databinding.FragmentPSGoalBinding
interface OnCollectingFinishedListener {
    fun onCollectingFinished()
}
class PSGoalFragment : Fragment(),PlayerStatsProvider {

    private lateinit var goal: Number
    private lateinit var listener: OnCollectingFinishedListener


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
        binding.goalRG.setOnCheckedChangeListener{ group, id ->
            goal = group.indexOfChild(group.findViewById<RadioButton>(id))
            binding.finish.visibility = View.VISIBLE
        }
        binding.finish.setOnClickListener {
            //TODO set on preferences to finish Collecting of User Data and push data to firebase
//            collectingPlayerStatsFinished()
            listener.onCollectingFinished()
            findNavController().navigate(R.id.action_viewPagerFragment2_to_pagesControllerFragment)
        }

        binding.back.setOnClickListener {
            viewPager2?.currentItem = 5
        }


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCollectingFinishedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnCollectingFinishedListener")
        }
    }



    override fun provideData(playerStats: PlayerStats) {
        playerStats.goal = goal
    }


}