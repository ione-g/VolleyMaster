package eone.grim.volleymaster.data.model

data class ExerciseItem(
    val exerciseId: String?,
    val name: String?,
    val description: String?,
    val instruction: String?,
    val restrictions: String?,
    val videoInstructionLink: String?,
    val equipments: ArrayList<String>?,
    val type: String?,
    val duration: Number?
)
