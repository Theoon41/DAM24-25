package com.example.unscramble.data

import java.util.prefs.Preferences;

data class UserPreferences(
    val language: String,
    val levelGame: Int
){
    companion object {
        const val SETTINGS_FILE = "settings"
    }
}

enum class Language(val language: String) {
    ENGLISH("en"),SPANISH("es")
}

enum class LevelGame(val level: Int) {
    EASY(5),MEDIUM(10),HARD(15)
}
