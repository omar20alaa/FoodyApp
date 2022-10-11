package app.foody_app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.foody_app.global.Constants.Companion.FAVORITE_RECIPES_TABLE
import app.foody_app.models.Result

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)