package eone.grim.volleymaster.ui.home.playerstats.collecting

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentFirstOnBoardScreenBinding
import eone.grim.volleymaster.databinding.FragmentPSGenderBinding


class PSGenderFragment : Fragment() {
    private val binding : FragmentPSGenderBinding by lazy {
        FragmentPSGenderBinding.inflate(layoutInflater)
    }


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
            femaleBtn.isChecked = false
            otherBtn.isChecked = false

        }
        femaleBtn.setOnClickListener{
            binding.next.visibility = View.VISIBLE
            maleBtn.isChecked = false
            otherBtn.isChecked = false

        }
        otherBtn.setOnClickListener{
            binding.next.visibility = View.VISIBLE
            femaleBtn.isChecked = false
            maleBtn.isChecked = false

        }
    }
}