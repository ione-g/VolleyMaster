package eone.grim.volleymaster.data.model

data class PlayerStats(
    var gender: Number?,
    var age: Number?,
    var weight: Number?,
    var height: Number?,
    var heightJump: Number?,
    var volleyLevel: Number?,
    var goal: Number?

) {
    fun toMap():Map<String,Any?> {
    return mapOf(
    "gender" to gender,
    "age" to age,
    "weight" to weight,
    "height" to height,
    "heightJump" to heightJump,
    "volleyLevel" to volleyLevel,
    "goal" to goal
    )
    }
}
