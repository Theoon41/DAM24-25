package com.example.unscramble.ui.game

import android.text.Spannable.Factory
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unscramble.data.Language
import com.example.unscramble.data.LevelGame
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.UserPreferences
import com.example.unscramble.data.UserPreferencesRepository
import com.example.unscramble.data.allSpanishWords
import com.example.unscramble.ui.unscramble_release.UnscrambleReleaseApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// El context debe llamarse dentro una función Composable
// Por eso en el GameViewModel tenemos que pasarlo por parámetro
// Dentro la función Composable en la que llamemos al GameViewModel tenemos que poner ...
// val context = LocalContext.current
class GameViewModel(
    private val userPrefsRepo: UserPreferencesRepository
) : ViewModel (){

    companion object{
        val Factory:ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATTION_KEY] as UnscrambleReleaseApplication)
                GameViewModel(application.userPreferencesRepository)
            }
        }
    }

    // Este estado va cambiando según vaya escribiendo
    var userGuess by mutableStateOf("")
        // Solo permite cambiar el valor de forma interna
        private set

    // Game UI state
    // Setter de uiState
    private val _uiState = MutableStateFlow(GameUiState())
    // Getter de uiState
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // Ejemplo de encapsulamiento en Kotlin
    // Setter -> Solo lo utilizamos para cambiar el valor
    private var _count = 0
    // Si actualizas _count -> count se actualiza también
    // Getter -> Solo muestra el valor de _count
    val count
        get() = _count

    // lateinit -> es una variable que se va a inicializar más tarde
    private lateinit var currentWord: String

    // Palabras usadas
    private var usedWords: MutableSet<String> = mutableSetOf()

    init {
        //resetGame()
        setSettings()
        //getSettings()
    }
    
    fun setSettings (language: String = Language.ENGLISH.language, levelGame: Int = LevelGame.EASY.level){
        viewModelScope.launch(){
            try{
                userPrefsRepo.savePreferences(
                    UserPreferences(language, levelGame)
                )
                updateStateSettings(language, levelGame)
            }catch(e:Exception){
                Log.e("GameViewModel", "Error al guardar en DataStore")
                _uiState.update { 
                    it.copy(
                        userMessages = "Error al guardar en DataStore"
                    )
                }
            }
            
        }
    }

    private fun updateStateSettings(language: String, levelGame: Int) {
        usedWords.clear()
        _uiState.update { currentState ->
            currentState.copy(
                currentScrambledWord = pickRandomWordAndShuffle(language),
                maxNumPalabras = levelGame,
                language = language,
                levelGame = levelGame,
                currentWordCount = 1,
                isGameOver = false,
                isLoading = false
            )
        }

    }

    fun getSettings() {
        viewModelScope.launch {
            userPrefsRepo.userPrefs.collect() { preferences ->
                updateStateSettings(preferences.language, preferences.levelGame)
            }
        }
    }

    // Selecciona 1 palabra aleatoria, sin repetir
    private fun pickRandomWordAndShuffle(language: String): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allSpanishWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle(language)
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    // Baraja las letras de la palabra asignada
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    // Reinicia el juego, es decir borra la lista de palabras usadas
    fun resetGame() {
        updateStateSettings(uiState.value.language, uiState.value.levelGame)
        //usedWords.clear()
        //_uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    // Nos permite cambiar el valor de userGuess que tiene el setter privado
    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // Coge la puntuación actual y le incrementa los puntos
            val newScore = uiState.value.score.plus(SCORE_INCREASE)

            // Actualiza el estado de los puntos y selecciona una palabra nueva aleatoria
            updateGameState(newScore)
        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(score: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                score = score,
                isGuessedWordWrong = false,
                currentScrambledWord = pickRandomWordAndShuffle(),
                currentWordCount = currentState.currentWordCount.inc()
            )
        }
    }


    // Ejemplo de actualización
    /*
    init {
        _uiState.update {
            it.copy(count = it.count+1)
        }
    }
    */

}