package eone.grim.volleymaster.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.utils.ViewPagerAdapter


class ViewPagerFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstOnBoardScreen(),
            SecondOnBoardScreen(),
            ThirdOnBoardScreen(),
            FourthOnBoardScreen(),
            FifthOnBoardScreen(),
            SixthOnBoardScreen()
        )

        var adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)

        viewPager.adapter = adapter
        return view
    }


}