package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPSVolleyLevelBinding

class PSVolleyLevelFragment : Fragment() {

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
        binding.levelRG.setOnCheckedChangeListener{ _, _ ->
            binding.next.visibility = View.VISIBLE
        }
        return view
    }


}