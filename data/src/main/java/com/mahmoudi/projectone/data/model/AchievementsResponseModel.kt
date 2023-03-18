package com.mahmoudi.projectone.data.model

import com.google.gson.annotations.SerializedName
import java.net.IDN

data class AchievementsResponseModel(

@SerializedName("id")
    val idAchievement : Int,

    val title : String,

    val label : String,

    val records : List<RecordsModel>
)
