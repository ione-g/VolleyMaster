package eone.grim.volleymaster.ui.main.pages.home

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.TrainingItem
import eone.grim.volleymaster.databinding.FragmentHomeBinding
import eone.grim.volleymaster.utils.TrainingAdapter
import eone.grim.volleymaster.viewmodels.PlayerViewModel
import eone.grim.volleymaster.viewmodels.TrainingViewModel

class HomeFragment : Fragment(){
    val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var trainingViewModel: TrainingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadUIBasedOnUserData()
        binding.root.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
        return binding.root
    }

    private fun loadUIBasedOnUserData() {

        showCurrentUsername()

        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(binding.planProgress.id,PlanProgressFragment())
        fragmentTransaction?.commit()


        binding.seeAllTrainings.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.action_trainings)
        }

        setUpRV()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRV() {
        val recyclerView = binding.trainingsRV
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var trainingAdapter:TrainingAdapter
        trainingViewModel = ViewModelProvider(requireActivity())[TrainingViewModel::class.java]
        trainingViewModel.trainingShort.observe(viewLifecycleOwner) {
            trainingAdapter = TrainingAdapter(it,findNavController())

            trainingAdapter.notifyDataSetChanged()
            recyclerView.adapter = trainingAdapter
        }
    }

    private fun showCurrentUsername() {
        playerViewModel = ViewModelProvider(requireActivity())[PlayerViewModel::class.java]

        // Observe the LiveData from the ViewModel
        playerViewModel.username.observe(viewLifecycleOwner, Observer { username ->
            binding.usernameTV.text = username ?: "Who are you?"
        })
        // Fetch user data
        playerViewModel.fetchUserData()
    }


}