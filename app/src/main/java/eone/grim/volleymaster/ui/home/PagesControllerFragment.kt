package eone.grim.volleymaster.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPagesControllerBinding




class PagesControllerFragment : Fragment() {
    val binding: FragmentPagesControllerBinding by lazy {
        FragmentPagesControllerBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.pagesNavigation
        return binding.root
    }}