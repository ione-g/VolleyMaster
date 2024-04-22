package eone.grim.volleymaster.ui.home.playerstats.collecting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPSAgeBinding
import eone.grim.volleymaster.databinding.FragmentPSHeightBinding
import eone.grim.volleymaster.databinding.FragmentPSJumpHeightBinding
import eone.grim.volleymaster.ui.home.playerstats.collecting.utils.BasicNumberPickerAdapter

class PSJumpHeightFragment : Fragment() {

    private val binding: FragmentPSJumpHeightBinding by lazy {
        FragmentPSJumpHeightBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 5
        }

        binding.back.setOnClickListener {
            viewPager2?.currentItem = 3
        }

        val adapter = BasicNumberPickerAdapter()
        adapter.values = (150..370).toList()
        binding.heightPicker.adapter = adapter
        binding.heightPicker.itemHeight = 300
        binding.heightPicker.isCyclic = true
        binding.heightPicker.setOnValueSelectedListener{ _,_ ->
            binding.next.visibility = View.VISIBLE
        }
        return view
    }


}