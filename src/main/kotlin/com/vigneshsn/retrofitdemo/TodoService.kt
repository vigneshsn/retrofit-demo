package com.vigneshsn.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface TodoService {
    @GET("todos")
    fun getTodoList(): Call<List<Todo>>
}