package co.pop.data.networking.model

import co.pop.data.database.model.WeatherEntity
import co.pop.data.networking.base.RoomMapper

data class WeatherInfoResponse(val id: Int? = 0, val weather: List<Weather>?, val main: MainInfo?, val name: String? = "") : RoomMapper<WeatherEntity> {
    override fun mapToRoomEntity() = WeatherEntity(id ?: 0, weather ?: emptyList(), main ?: MainInfo(), name)
}

data class MainInfo(val temp: Double? = 0.0, val pressure: Double? = 0.0, val humidity: Int? = 0)

data class Weather(val id: Int? = 0, val main: String? = "", val description: String? = "", val icon: String? = "")