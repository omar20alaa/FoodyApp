package app.foody_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.foody_app.entity.FavoritesEntity
import app.foody_app.entity.FoodJokeEntity
import app.foody_app.entity.RecipesEntity

@Database(
    entities = [RecipesEntity::class, FavoritesEntity::class , FoodJokeEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {


    abstract fun recipesDao(): RecipesDao


}