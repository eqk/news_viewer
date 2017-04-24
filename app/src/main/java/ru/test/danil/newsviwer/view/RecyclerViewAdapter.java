package ru.test.danil.newsviwer.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.test.danil.newsviwer.R;
import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.presenter.NewsPresenter;

/**
 * Created by Krylov Danil on 22.04.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<News> newsList = new ArrayList<>();

    private NewsPresenter presenter;

    public RecyclerViewAdapter(ArrayList<News> list, NewsPresenter presenter)
    {
        this.newsList = list;
        this.presenter = presenter;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final News news = newsList.get(i);
        viewHolder.title.setText(news.getTitle());
        viewHolder.text.setText(news.getText());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickNews(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView text;
        private Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textViewTitle);
            text = (TextView) itemView.findViewById(R.id.textViewText);
            button = (Button) itemView.findViewById(R.id.buttonDetail);
        }
    }

}
