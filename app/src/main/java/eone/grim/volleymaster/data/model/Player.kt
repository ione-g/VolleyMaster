package eone.grim.volleymaster.data.model

import java.util.Date

data class Player(
    var username:String?,
    var phone: String?,
    var email: String?,
    var stats: PlayerStats,
    var birthdate: Date?,
    var height: Int?,
    var weight: Int?,
    var jumpHeight: Int?

)
