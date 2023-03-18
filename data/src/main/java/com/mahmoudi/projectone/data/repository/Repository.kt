package com.mahmoudi.projectone.data.repository

import com.mahmoudi.projectone.data.api.ProjectApi
import com.mahmoudi.projectone.data.model.AchievementsResponseModel


class Repository (val projectApi: ProjectApi) {
    suspend fun getAchievements(): List<AchievementsResponseModel> {
        return projectApi.getAchivements().data
    }
}