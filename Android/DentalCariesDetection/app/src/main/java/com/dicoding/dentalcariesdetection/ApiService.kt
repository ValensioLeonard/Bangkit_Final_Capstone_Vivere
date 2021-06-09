package com.dicoding.dentalcariesdetection

import okhttp3.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Multipart
    @POST("predict")
    fun postImage(
        @Part file: MultipartBody.Part
    ): Call<PostImageResponse>
}
