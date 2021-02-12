package com.example.etudiodibri.model

import com.google.gson.annotations.SerializedName
import java.time.Year

data class DibreResponse(

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

)
