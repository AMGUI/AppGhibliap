package com.example.etudiodibri.model

import android.content.Context
import com.google.gson.annotations.SerializedName
import java.time.Year
import java.util.*

data class GhibliResponse(

    @SerializedName("id")
    val id           : String,

    @SerializedName("title")
    val title        : String,

    @SerializedName("description")
    val description  : String,

    @SerializedName("director")
    val director     : String,

    @SerializedName("producer")
    val producer     : String,

    @SerializedName("release_date")
    val release_date : String,

    @SerializedName("rt_score")
    val rt_score     : Double

){

private fun getThumbnailName(): String {
    //example: My Neighbor Totoro = my_neighbor_totoro
    return title
        .toLowerCase(Locale.getDefault())
        .replace(" ", "_")
        .replace("'", "")
}

fun getThumbnail(context: Context): Int {
    return context.resources
        .getIdentifier(getThumbnailName(), "drawable", context.packageName)
}
}