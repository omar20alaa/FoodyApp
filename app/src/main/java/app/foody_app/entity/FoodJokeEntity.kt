package app.foody_app.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.foody_app.global.Constants.Companion.FOOD_JOKE_TABLE
import app.foody_app.models.FoodJoke

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(
    @Embedded
    var foodJoke: FoodJoke
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}