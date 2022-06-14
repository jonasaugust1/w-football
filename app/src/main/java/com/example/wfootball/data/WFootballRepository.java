package com.example.wfootball.data;

import androidx.room.Room;

import com.example.wfootball.App;
import com.example.wfootball.data.local.WFootballDb;
import com.example.wfootball.data.remote.WFootballApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WFootballRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://jonasaugust1.github.io/w-footbal-api/";
    private static final String LOCAL_DB_NAME = "w-news";
    //endregion

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    private WFootballApi remoteApi;
    private WFootballDb localDb;

    public WFootballApi getRemoteApi() {
        return remoteApi;
    }

    public WFootballDb getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private WFootballRepository() {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WFootballApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), WFootballDb.class, LOCAL_DB_NAME).build();
    }

    public static WFootballRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final WFootballRepository INSTANCE = new WFootballRepository();
    }
    //endregion
}
