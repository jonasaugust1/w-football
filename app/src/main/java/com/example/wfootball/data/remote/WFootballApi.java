package com.example.wfootball.data.remote;

import com.example.wfootball.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WFootballApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
