package eone.grim.volleymaster.data.model

data class TrainingDetailedItem(
    val trainingId: String,
    val imageResource: String,
    val trainingName: String,
    val trainingDesc: String,
    var trainingExercises: ArrayList<String>

    )
