package android.mkv.newsappcompose.data.manager

import android.content.Context
import android.mkv.newsappcompose.domain.manager.LocalUserManager
import android.mkv.newsappcompose.util.Constants
import android.mkv.newsappcompose.util.Constants.USER_SETTING
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { setting ->
            setting[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false

        }
    }


}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTING)

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}

