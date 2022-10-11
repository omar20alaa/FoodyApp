package app.foody_app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.foody_app.global.Constants.Companion.DATABASE_TABLE
import app.foody_app.models.FoodRecipe

@Entity(tableName = DATABASE_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
