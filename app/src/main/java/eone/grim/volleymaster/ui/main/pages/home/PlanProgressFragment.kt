package eone.grim.volleymaster.ui.main.pages.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eone.grim.volleymaster.databinding.FragmentPlanProgressBinding


class PlanProgressFragment : Fragment() {

    val binding: FragmentPlanProgressBinding by lazy {
        FragmentPlanProgressBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }


}