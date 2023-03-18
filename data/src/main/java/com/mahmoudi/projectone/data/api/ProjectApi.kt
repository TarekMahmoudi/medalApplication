package com.mahmoudi.projectone.data.api

import com.mahmoudi.projectone.data.model.WrappedAchievementsResponseModel
import retrofit2.http.GET

interface ProjectApi {
    @GET("achievements")
    suspend fun getAchivements(): WrappedAchievementsResponseModel

}