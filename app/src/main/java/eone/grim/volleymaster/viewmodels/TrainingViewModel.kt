package eone.grim.volleymaster.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.data.model.ExerciseItem
import eone.grim.volleymaster.data.model.TrainingDetailedItem
import eone.grim.volleymaster.data.model.TrainingItem

class TrainingViewModel: ViewModel() {

    init {
        fetchTrainingShortData()
        fetchTrainingDetailedData()
        fetchExercises()
    }

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


    private val _trainingDetailed = MutableLiveData<MutableMap<String,TrainingDetailedItem>>()
    val trainingDetailed: LiveData<MutableMap<String,TrainingDetailedItem>> = _trainingDetailed

    fun fetchTrainingDetailedData() {
        val db = FirebaseFirestore.getInstance()
        val trainingList = mutableMapOf<String, TrainingDetailedItem>()
        val trainingIds = mutableListOf<String>()

        db.collection("TRAININGS")
            .get()
            .addOnSuccessListener { trainings ->
                if (trainings.isEmpty) {
                    Log.d("Load not Successful", "Can't find any data")
                } else {
                    for (trainDoc in trainings) {
                        val trainingId = trainDoc.id
                        trainingIds.add(trainingId)
                        trainingList[trainingId] = TrainingDetailedItem(
                            trainingId,
                            trainDoc.data["imageResource"].toString(),
                            trainDoc.data["trainingName"].toString(),
                            trainDoc.data["trainingDesc"].toString(),
                            arrayListOf()
                        )
                    }

                    fetchDetailedInfoList(trainingList)
                }
            }
    }

    private fun fetchDetailedInfoList( trainingList: MutableMap<String, TrainingDetailedItem>) {
        val db = FirebaseFirestore.getInstance()
        db
            .collection("TRAININGS_DETAILED")
            .get()
            .addOnSuccessListener {trains ->
                if (trains.isEmpty) {
                    //TODO FAILURE OF FETCHING
                } else {
                    for (train in trains) {
                        Log.i("check exercises", train["exercises"].toString())
                        trainingList[train.id]!!.trainingExercises = train["exercises"] as ArrayList<String>
                    }
                }
                _trainingDetailed.value = trainingList
            }
    }

    private val _exercises = MutableLiveData<MutableMap<String,ExerciseItem>>()
    val exercises: LiveData<MutableMap<String,ExerciseItem>> = _exercises

    private fun fetchExercises() {
        val db = FirebaseFirestore.getInstance()
        val exercisesMap = mutableMapOf<String,ExerciseItem>()
        db
            .collection("EXERCISES")
            .get()
            .addOnSuccessListener {exercisesList->
                if (exercisesList.isEmpty) {
                    //TODO FAILURE OF FETCHING
                } else {
                    for (ex in exercisesList) {
                        exercisesMap[ex.id] = ExerciseItem(
                            ex.id,
                            ex["name"] as String?,
                            ex["description"] as String?,
                            ex["instruction"] as String?,
                            ex["restrictions"] as String?,
                            ex["videoInstruction"] as String?,
                            ex["equipments"] as ArrayList<String>?,
                            ex["type"] as String?,
                            ex["durations"] as Number?
                        )
                    }
                }
                _exercises.value = exercisesMap

            }

    }
}