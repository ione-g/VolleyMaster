package eone.grim.volleymaster.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.data.model.TrainingItem

class TrainingViewModel: ViewModel() {

    private val _trainingShort = MutableLiveData<MutableList<TrainingItem>>()
    val trainingShort: LiveData<MutableList<TrainingItem>> = _trainingShort

    fun fetchTrainingShortData() {
        val db = FirebaseFirestore.getInstance()
        val trainingList = mutableListOf<TrainingItem>()
        db.collection("TRAININGS")
            .get()
            .addOnSuccessListener {
                if (it.isEmpty) {
                    Log.d("Load not Successful", "Can`t find any data")
                } else {
                    for (train in it) {
                        trainingList.add(
                            TrainingItem(
                                train.id,
                                train.data["imageResource"].toString(),
                                train.data["trainingName"].toString(),
                                train.data["trainingDesc"].toString()
                            )
                        )
                    }
                    _trainingShort.value = trainingList
                }
            }
    }


}