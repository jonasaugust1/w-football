package com.example.wfootball.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wfootball.data.WFootballRepository;
import com.example.wfootball.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return WFootballRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> WFootballRepository.getInstance().getLocalDb().newsDao().save(news));
    }

}