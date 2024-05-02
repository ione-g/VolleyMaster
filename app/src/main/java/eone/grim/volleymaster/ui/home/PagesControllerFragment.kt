package eone.grim.volleymaster.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentPagesControllerBinding
import eone.grim.volleymaster.ui.home.pages.home.HomeFragment
import eone.grim.volleymaster.ui.home.pages.profile.ProfileFragment
import eone.grim.volleymaster.ui.home.pages.SettingsFragment
import eone.grim.volleymaster.ui.home.pages.trainings.TrainingsFragment
import eone.grim.volleymaster.utils.interfaces.OnTrainingSelectedListener
import eone.grim.volleymaster.viewmodels.TrainingViewModel


class PagesControllerFragment : Fragment() {
    val binding: FragmentPagesControllerBinding by lazy {
        FragmentPagesControllerBinding.inflate(layoutInflater)
    }


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
        replaceFragment(HomeFragment())
        binding.pagesNavigation.setOnItemSelectedListener {
        when(it.itemId) {
            R.id.action_home-> replaceFragment(HomeFragment())
            R.id.action_trainings-> replaceFragment(TrainingsFragment())
            R.id.action_settings-> replaceFragment(SettingsFragment())
            R.id.action_profile-> replaceFragment(ProfileFragment())
            else -> {

            }
        }
        true

    }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val trainingViewModel: TrainingViewModel = ViewModelProvider(requireActivity()).get(TrainingViewModel::class.java)
        trainingViewModel.selectedTrainingItem.observe(viewLifecycleOwner) { trainingItem ->
            // When a training item is selected, navigate to the detail fragment
            val trainingsFragment = TrainingsFragment().apply {
                arguments = Bundle().apply {
                    // put your training details here
                }
            }
            replaceFragmentAndGoToNav(trainingsFragment, R.id.action_trainings)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.pageReplacer,fragment)
        fragmentTransaction?.commit()
    }
    private fun replaceFragmentAndGoToNav(fragment: Fragment,actionId:Int) {
        binding.pagesNavigation.selectedItemId = actionId
        replaceFragment(fragment)
    }




}