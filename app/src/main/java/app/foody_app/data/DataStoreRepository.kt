package app.foody_app.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import app.foody_app.global.Constants.Companion.DEFAULT_DIET_TYPE
import app.foody_app.global.Constants.Companion.DEFAULT_MEAL_TYPE
import app.foody_app.global.Constants.Companion.PREFERENCES_NAME
import app.foody_app.global.Constants.Companion.PREFERENCE_BACK_ONLINE
import app.foody_app.global.Constants.Companion.PREFERENCE_DIET_TYPE
import app.foody_app.global.Constants.Companion.PREFERENCE_DIET_TYPE_ID
import app.foody_app.global.Constants.Companion.PREFERENCE_MEAL_TYPE
import app.foody_app.global.Constants.Companion.PREFERENCE_MEAL_TYPE_ID
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

@ActivityRetainedScoped
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object PreferencesKey {
        val selectedMealType = preferencesKey<String>(PREFERENCE_MEAL_TYPE)
        val selectedMealTypeId = preferencesKey<Int>(PREFERENCE_MEAL_TYPE_ID)
        val selectedDietType = preferencesKey<String>(PREFERENCE_DIET_TYPE)
        val selectedDietTypeId = preferencesKey<Int>(PREFERENCE_DIET_TYPE_ID)
        val backOnline = preferencesKey<Boolean>(PREFERENCE_BACK_ONLINE)
    }

    private val dataStore: DataStore<androidx.datastore.preferences.Preferences> = context.createDataStore(
        name = PREFERENCES_NAME
    )

    suspend fun saveMealAndDietType(
        mealType: String,
        mealTypeId: Int,
        dietType: String,
        dietTypeId: Int
    ) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.selectedMealType] = mealType
            preferences[PreferencesKey.selectedMealTypeId] = mealTypeId
            preferences[PreferencesKey.selectedDietType] = dietType
            preferences[PreferencesKey.selectedDietTypeId] = dietTypeId
        }
    }

    suspend fun saveBackOnline(backOnline: Boolean) {
        dataStore.edit { preference ->
            preference[PreferencesKey.backOnline] = backOnline
        }
    }


    val readMealAndDietType: kotlinx.coroutines.flow.Flow<MealAndDietType> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val selectedMealType = preferences[PreferencesKey.selectedMealType] ?: DEFAULT_MEAL_TYPE
            val selectedMealTypeId = preferences[PreferencesKey.selectedMealTypeId] ?: 0
            val selectedDietType = preferences[PreferencesKey.selectedDietType] ?: DEFAULT_DIET_TYPE
            val selectedDietTypeId = preferences[PreferencesKey.selectedDietTypeId] ?: 0
            MealAndDietType(
                selectedMealType,
                selectedMealTypeId,
                selectedDietType,
                selectedDietTypeId
            )
        }

    val readBackOnline: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val backOnline = preferences[PreferencesKey.backOnline] ?: false
            backOnline
        }

}


data class MealAndDietType(
    val selectedMealType: String,
    val selectedMealTypeId: Int,
    val selectedDietType: String,
    val selectedDietTypeId: Int
)
