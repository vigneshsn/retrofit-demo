package com.vigneshsn.retrofitdemo

import mu.KotlinLogging
import okhttp3.OkHttpClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val logger = KotlinLogging.logger {  }

@SpringBootApplication
class RetrofitDemoApplication

fun main(args: Array<String>) {
	runApplication<RetrofitDemoApplication>(*args)
	val retrofit = client()
	val callTodo = retrofit.create(TodoService::class.java)
			.getTodoList()
	val response = callTodo.execute()
	logger.info { response.body() }
}

@Bean
fun client(): Retrofit {
	return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.client(OkHttpClient().newBuilder().build())
			.build()
}
