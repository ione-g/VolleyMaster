package eone.grim.volleymaster.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPagesControllerBinding
import eone.grim.volleymaster.ui.main.pages.home.HomeFragment
import eone.grim.volleymaster.ui.main.pages.trainings.TrainingsFragment
import eone.grim.volleymaster.viewmodels.TrainingViewModel


class PagesControllerFragment : Fragment() {
    val binding: FragmentPagesControllerBinding by lazy {
        FragmentPagesControllerBinding.inflate(layoutInflater)
    }
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.root.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.pageReplacer) as NavHostFragment
        val navController = navHostFragment.navController
        binding.pagesNavigation.setupWithNavController(navController)

    }







}