package eone.grim.volleymaster.ui.home.playerstats.collecting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.ui.unit.dp
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPSAgeBinding
import eone.grim.volleymaster.ui.home.playerstats.collecting.utils.BasicNumberPickerAdapter
import io.woong.wheelpicker.ValuePickerAdapter
import io.woong.wheelpicker.ValuePickerView


class PSAgeFragment : Fragment() {

    private val binding: FragmentPSAgeBinding by lazy {
        FragmentPSAgeBinding.inflate(layoutInflater)
    }

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
        binding.agePicker.setOnValueSelectedListener{ _,_ ->
            binding.next.visibility = View.VISIBLE
        }
        return view
    }


}

