package com.example.geofinder.data
import com.google.gson.annotations.SerializedName


data class MapSurveyDTO(
    @SerializedName("documentation") val documentation: String,
    @SerializedName("licenses") val licenses: List<License>,
    @SerializedName("rate") val rate: Rate,
    @SerializedName("results") val results: List<Result>,
    @SerializedName("status") val status: Status,
    @SerializedName("stay_informed") val stayInformed: StayInformed,
    @SerializedName("thanks") val thanks: String,
    @SerializedName("timestamp") val timestamp: Timestamp,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("base64Map") val base64Map: String
)

data class License(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Rate(
    @SerializedName("limit") val limit: Int,
    @SerializedName("remaining") val remaining: Int,
    @SerializedName("reset") val reset: Long
)

data class Result(
    @SerializedName("annotations") val annotations: Annotations,
    //@SerializedName("bounds") val bounds: WindowInsetsAnimation.Bounds,
    //@SerializedName("components") val components: Components,
    @SerializedName("confidence") val confidence: Int,
    @SerializedName("formatted") val formatted: String,
    //@SerializedName("geometry") val geometry: Geometry
)

data class Annotations(
    @SerializedName("dms") val dms: DMS,
    @SerializedName("mgrs") val mgrs: String,
    @SerializedName("maidenhead") val maidenhead: String,
    @SerializedName("mercator") val mercator: Mercator,
    //@SerializedName("osm") val osm: OSM,
    //@SerializedName("uN_M49") val unM49: UNM49,
    @SerializedName("callingcode") val callingcode: Int,
    //@SerializedName("currency") val currency: Currency,
    @SerializedName("flag") val flag: String,
    @SerializedName("geohash") val geohash: String,
    @SerializedName("qibla") val qibla: Double,
    //@SerializedName("roadinfo") val roadinfo: RoadInfo,
    //@SerializedName("sun") val sun: Sun,
    //@SerializedName("timezone") val timezone: Timezone,
    //@SerializedName("what3words") val what3words: What3Words
)

data class DMS(
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String
)

data class Mercator(
    @SerializedName("x") val x: Double,
    @SerializedName("y") val y: Double
)

// Defina classes correspondentes para as outras partes do JSON, como Bounds, Components, Currency, etc.

data class Status(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)

data class StayInformed(
    @SerializedName("blog") val blog: String,
    @SerializedName("mastodon") val mastodon: String
)

data class Timestamp(
    @SerializedName("created_http") val createdHttp: String,
    @SerializedName("created_unix") val createdUnix: Long
)