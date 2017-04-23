package ru.test.danil.newsviwer.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mifmif.common.regex.Main;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.test.danil.newsviwer.R;
import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.presenter.IPresenter;
import ru.test.danil.newsviwer.presenter.NewsPresenter;
import ru.test.danil.newsviwer.view.IView;
import ru.test.danil.newsviwer.view.MainActivity;
import ru.test.danil.newsviwer.view.RecyclerViewAdapter;

/**
 * Created by Krylov Danil on 23.04.2017.
 */

public class NewsListFragment extends Fragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    private NewsPresenter presenter = new NewsPresenter(this);

    private MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter(new ArrayList<News>(), presenter);
        recyclerView.setAdapter(adapter);

        presenter.onCreate(savedInstanceState);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (MainActivity) this.getActivity();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    public void showList(List<News> newsList)
    {
        adapter.setNewsList(newsList);
    }

    public void startNewsDetailFragment(News news) {
        activity.startNewsDetailFragment(news);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }
}
