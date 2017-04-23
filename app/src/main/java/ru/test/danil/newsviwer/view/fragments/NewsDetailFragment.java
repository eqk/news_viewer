package ru.test.danil.newsviwer.view.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.test.danil.newsviwer.R;
import ru.test.danil.newsviwer.model.News;

/**
 * Created by Krylov Danil on 23.04.2017.
 */

public class NewsDetailFragment extends Fragment {
    @Bind(R.id.textViewDetailTitle)
    TextView title;

    @Bind(R.id.textViewDetailText)
    TextView text;

    private static final String BUNDLE_NEWS_KEY = "BUNDLE_NEWS_KEY";

    private News getNews(){
        return (News) getArguments().getSerializable(BUNDLE_NEWS_KEY);
    }

    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment myFragment = new NewsDetailFragment();

        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_NEWS_KEY, news);
        myFragment.setArguments(args);

        return myFragment;
    }

    public void showDetailNews(News news)
    {
        title.setText(news.getTitle());
        text.setText(news.getText());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ButterKnife.bind(this, view);
        showDetailNews(getNews());
        return view;
    }
}
