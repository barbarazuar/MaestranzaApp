package com.example.maestranzaapp.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        private val SEARCH_KEY = stringPreferencesKey("search_text")
    }

    val searchTextFlow: Flow<String> =
        context.dataStore.data.map { prefs ->
            prefs[SEARCH_KEY] ?: ""
        }

    suspend fun saveSearchText(text: String) {
        context.dataStore.edit { prefs ->
            prefs[SEARCH_KEY] = text
        }
    }
}