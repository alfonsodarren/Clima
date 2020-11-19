package co.pop.data.database.dao

import androidx.room.Dao
import androidx.room.Transaction
import co.pop.data.networking.model.Favorite

@Dao
interface FavoriteDAO {
    @Transaction
    suspend fun getFavorites(): List<Favorite>

    suspend fun insertOrUpdateFavorite()
}