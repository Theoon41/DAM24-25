package com.example.unscramble.data

import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences


class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
){
    private companion object {
        val LANGUAGE = stringPreferencesKey("language")
        val LEVEL_GAME = intPreferencesKey("level_game")
    }


    suspend fun savePreferences(userPrefs : UserPreferences) {
        dataStore.edit{ preferences ->
            preferences[LANGUAGE] = userPrefs.language
            preferences[LEVEL_GAME] = userPrefs.levelGame
        }
    }


    val userPrefs : Flow<UserPreferences> = dataStore.data.map { preferences ->
        val language = preferences[LANGUAGE] ?: "en"
        val levelGame = preferences[LEVEL_GAME] ?: LevelGame.EASY.level
        UserPreferences(language, levelGame)
    }
}