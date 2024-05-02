package eone.grim.volleymaster.ui.main.pages.trainings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.FragmentTrainingsBinding
import eone.grim.volleymaster.viewmodels.TrainingViewModel

class TrainingsFragment : Fragment() {

    private val binding: FragmentTrainingsBinding by lazy {
        FragmentTrainingsBinding.inflate(layoutInflater)
    }

    private lateinit var trainingViewModel:TrainingViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trainingViewModel = ViewModelProvider(requireActivity())[TrainingViewModel::class.java]

        return binding.root
    }


}