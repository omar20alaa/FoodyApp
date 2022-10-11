package app.foody_app.data

import app.foody_app.data.network.ApiConnection
import app.foody_app.models.FoodJoke
import app.foody_app.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiConnection: ApiConnection
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return apiConnection.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe> {
        return apiConnection.searchRecipes(searchQuery)
    }

    suspend fun getFoodJoke(apiKey: String): Response<FoodJoke> {
        return apiConnection.getFoodJoke(apiKey)
    }

}