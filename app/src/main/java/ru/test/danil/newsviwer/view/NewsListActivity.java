package ru.test.danil.newsviwer.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ru.test.danil.newsviwer.R;
import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.presenter.IPresenter;
import ru.test.danil.newsviwer.presenter.NewsPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsListActivity extends AppCompatActivity implements IView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);

        presenter = new NewsPresenter(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        presenter.onCreate();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    public void showList(List<News> newsList)
    {
        adapter.setNewsList(newsList);
    }
}
