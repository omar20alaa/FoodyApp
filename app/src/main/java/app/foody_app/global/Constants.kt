package app.foody_app.global

class Constants {

    companion object {

        const val BASE_URL = "https://api.spoonacular.com/"
        const val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"
        const val API_KEY = "68f38405557d4fa3a3e97ef80ff68ab5"

        const val RECIPE_RESULT_KEY = "recipeBundle"

        //API QUERY KEYS
        const val QUERY_SEARCH = "query"
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        // ROOM DATA BASE
        const val DATABASE_NAME = "recipes_database"
        const val DATABASE_TABLE = "recipes_table"
        const val FAVORITE_RECIPES_TABLE = "favorite_recipes_table"
        const val FOOD_JOKE_TABLE = "food_joke_table"


        // Bottom sheet and preference
        const val PREFERENCES_NAME = "foody_preferences"
        const val DEFAULT_RECIPES_NUMBER = "50"
        const val DEFAULT_MEAL_TYPE = "main course"
        const val DEFAULT_DIET_TYPE = "gluten free"
        const val PREFERENCE_MEAL_TYPE = "mealType"
        const val PREFERENCE_MEAL_TYPE_ID = "mealTypeId"
        const val PREFERENCE_DIET_TYPE = "dietType"
        const val PREFERENCE_DIET_TYPE_ID = "dietTypeId"
        const val PREFERENCE_BACK_ONLINE = "backOnline"

    }

}