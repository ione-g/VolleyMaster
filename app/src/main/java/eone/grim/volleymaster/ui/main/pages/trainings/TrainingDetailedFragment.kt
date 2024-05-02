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
import eone.grim.volleymaster.databinding.FragmentTrainingDetailedBinding
import eone.grim.volleymaster.databinding.FragmentTrainingsBinding
import eone.grim.volleymaster.viewmodels.TrainingViewModel

class TrainingDetailedFragment : Fragment() {
//    // TODO: Rename and change types of parameters
    private var trainingID: String? = null
    private val binding: FragmentTrainingDetailedBinding by lazy {
        FragmentTrainingDetailedBinding.inflate(layoutInflater)
    }

    private lateinit var trainingViewModel:TrainingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trainingID = it.getString("trainingId")
        }
        Log.i("trainingId",trainingID.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trainingViewModel = ViewModelProvider(requireActivity())[TrainingViewModel::class.java]

        val exercises = arrayListOf<String>()
        trainingID?.let {
            trainingViewModel.trainingDetailed.observe(viewLifecycleOwner) {
                exercises.addAll(it[trainingID]?.trainingExercises!!)
            }
        }

        trainingViewModel.exercises.observe(viewLifecycleOwner) {
            Glide.with(this)
                .asGif()
                .load(it[exercises[0]]?.videoInstructionLink)
                .placeholder(R.drawable.background_oval_shape)
                .into(binding.exerciseHolder)
        }

        return binding.root
    }


}