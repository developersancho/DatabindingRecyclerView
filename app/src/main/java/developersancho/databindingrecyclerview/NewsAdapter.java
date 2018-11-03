package developersancho.databindingrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import developersancho.databindingrecyclerview.databinding.NewsBinding;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<News> newsList;
    private LayoutInflater layoutInflater;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        //return new NewsViewHolder(item);
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        NewsBinding newsBinding = NewsBinding.inflate(layoutInflater, viewGroup, false);
        return new NewsViewHolder(newsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        News news = newsList.get(i);
        //newsViewHolder.textTitle.setText(news.getTitle());
        //newsViewHolder.textDesc.setText(news.getDesc());
        newsViewHolder.bind(news);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        //TextView textTitle, textDesc;
        NewsBinding newsBinding;

        public NewsViewHolder(NewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;
            //textTitle = itemView.findViewById(R.id.textTitle);
            //textDesc = itemView.findViewById(R.id.textDesc);
        }

        public void bind(News news) {
            this.newsBinding.setNewsView(news);
        }

        public NewsBinding getNewsBinding() {
            return newsBinding;
        }
    }
}
