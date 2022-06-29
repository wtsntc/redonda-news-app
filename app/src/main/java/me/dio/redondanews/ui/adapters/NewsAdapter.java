package me.dio.redondanews.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.redondanews.R;
import me.dio.redondanews.databinding.NewsItemBinding;
import me.dio.redondanews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;
    private final NewsAdapter.favoriteListener favoriteListener;

    public NewsAdapter(List<News> news, NewsAdapter.favoriteListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        News news = this.news.get(position);
        holder.binding.tvTitle.setText(news.title);
        holder.binding.TvDescription.setText(news.description);
        Picasso.get().load(news.image).fit().into(holder.binding.IvThumbnail);
        context = holder.itemView.getContext();
        Context finalContext1 = context;
        holder.binding.btOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.link));
            finalContext1.startActivity(i);
        });
        Context finalContext = context;
        holder.binding.IvShare.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, news.title);
            i.putExtra(Intent.EXTRA_TEXT, news.link);
            finalContext.startActivity(Intent.createChooser(i, "Share"));
        });
        holder.binding.IvFavorite.setOnClickListener(view -> {
            news.favorite = !news.favorite;
            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });
        int favoriteColor = news.favorite ? R.color.favorite_active : R.color.favorite_inactive;
        holder.binding.IvFavorite.setColorFilter(context.getResources().getColor(favoriteColor));

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface favoriteListener {
        void onFavorite(News news);
    }
}
