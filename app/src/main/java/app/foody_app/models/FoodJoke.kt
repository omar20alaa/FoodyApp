package app.foody_app.models

import com.google.gson.annotations.SerializedName


data class FoodJoke(
    @SerializedName("text")
    val text: String
)