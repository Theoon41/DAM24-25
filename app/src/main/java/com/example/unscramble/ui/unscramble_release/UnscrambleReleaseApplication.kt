package com.example.unscramble.ui.unscramble_release

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.unscramble.data.UserPreferences
import com.example.unscramble.data.UserPreferencesRepository


val Context.dataStore by preferencesDataStore(name = UserPreferences.SETTINGS_FILE)
class UnscrambleReleaseApplication : Application() {

    lateinit var userPreferencesRepository: UserPreferencesRepository
        private set

    //Contenedor de dependencias manuales que se usa por completo en la app
    override fun onCreate() {
        super.onCreate()

        //Instancias Singletone

        userPreferencesRepository = UserPreferencesRepository(this.dataStore)
    }

}