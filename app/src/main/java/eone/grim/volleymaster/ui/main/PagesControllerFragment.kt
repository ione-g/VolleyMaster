package eone.grim.volleymaster.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPagesControllerBinding


class PagesControllerFragment : Fragment() {
    val binding: FragmentPagesControllerBinding by lazy {
        FragmentPagesControllerBinding.inflate(layoutInflater)
    }
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressed()
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
        navController = navHostFragment.navController
        binding.pagesNavigation.setupWithNavController(navController)
        binding.pagesNavigation.setOnItemSelectedListener {item->
            when (item.itemId) {
                R.id.action_home -> {
                    navController.navigate(R.id.action_home)
                    true
                }
                R.id.action_trainings -> {
                    navController.navigate(R.id.action_trainings)
                    true
                }
                R.id.action_settings -> {
                    navController.navigate(R.id.action_settings)
                    true
                }
                R.id.action_profile -> {
                    navController.navigate(R.id.action_profile)
                    true
                }
                else -> false
            }
        }

    }

    fun onBackPressed(){
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navController.currentDestination?.id == R.id.action_home) {
                    // Handle back press at home_fragment (e.g., exit app)
                    requireActivity().finish() // or show a confirmation dialog
                } else {
                    // Navigate up in the navigation stack
                    navController.navigateUp()
                }
            }
        })
    }







}