package com.jomeva.myemoji.interfaces


import com.jomeva.myemoji.modelos.EmojiResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface IEmoji {
    @GET
    suspend fun obtenerEmoji(@Url url: String): Response<EmojiResponse>

    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://emojihub.yurace.pro/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}