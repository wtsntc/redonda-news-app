package me.dio.redondanews.ui.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.redondanews.domain.News;

public class FavoritesViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public FavoritesViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock de Noticias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria tem desfalque importante", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."));
        news.add(new News("Ferrinha joga no sábado", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."));
        news.add(new News("Copa dp mundo feminina está terminando", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}