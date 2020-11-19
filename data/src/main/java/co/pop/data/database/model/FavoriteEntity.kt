package co.pop.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.pop.data.database.FAVORITE_TABLE_NAME
import co.pop.data.networking.base.DomainMapper
import co.pop.domain.model.FavoriteInfo

@Entity(tableName = FAVORITE_TABLE_NAME)
data class FavoriteEntity(
    @PrimaryKey
    val id: Int? = 0,
    @ColumnInfo(name = "city_name")
    val cityName: String
) : DomainMapper<FavoriteInfo> {
    override fun mapToDomainModel() = FavoriteInfo(cityName)
}