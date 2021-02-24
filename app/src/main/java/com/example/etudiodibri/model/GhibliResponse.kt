package com.example.etudiodibri.model

import android.content.Context
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.time.Year
import java.util.*

@Parcelize
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

) : Parcelable
{

private fun getThumbnailName(): String {
    //example: My Neighbor Totoro = my_neighbor_totoro
    return title
        .toLowerCase()
        .replace(" ", "_")
        .replace("'", "")
}

fun getThumbnail(context: Context): Int {
    return context.resources
        .getIdentifier(getThumbnailName(), "drawable", context.packageName)
}
}