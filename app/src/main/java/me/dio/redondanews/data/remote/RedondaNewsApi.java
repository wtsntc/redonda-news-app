package me.dio.redondanews.data.remote;

import java.util.List;

import me.dio.redondanews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;


public interface RedondaNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();

}
