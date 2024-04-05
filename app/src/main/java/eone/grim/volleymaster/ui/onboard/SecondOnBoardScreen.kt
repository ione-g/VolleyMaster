package eone.grim.volleymaster.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentFirstOnBoardScreenBinding
import eone.grim.volleymaster.databinding.FragmentSecondOnBoardScreenBinding


class SecondOnBoardScreen : Fragment() {



    private val binding : FragmentSecondOnBoardScreenBinding by lazy {
        FragmentSecondOnBoardScreenBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root
        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.nextPage.setOnClickListener {
            viewPager2?.currentItem = 2
        }

        return view
        // Inflate the layout for this fragment
    }
}