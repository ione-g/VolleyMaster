package eone.grim.volleymaster.data.provider

import eone.grim.volleymaster.data.model.PlayerStats

interface PlayerStatsProvider {
    fun provideData(playerStats: PlayerStats)
}