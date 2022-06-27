package me.dio.redondanews.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.redondanews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        news = new MutableLiveData<>();

        //TODO Remover mock de noticias
        List<News> news =  new ArrayList<>();
        news.add(new News("Ferrovária tem desfalque importante",""));
        news.add(new News("Ferrinha joga no sabado", ""));
        news.add(new News("Copa do mundo feminina está terminando ", ""));

        this.news.setValue(news);
}

     public MutableLiveData<List<News>> getNews() {
    return  news;
    }
}
