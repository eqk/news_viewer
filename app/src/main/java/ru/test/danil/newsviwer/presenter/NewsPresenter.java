package ru.test.danil.newsviwer.presenter;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.test.danil.newsviwer.model.IModel;
import ru.test.danil.newsviwer.model.Model;

import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.view.IView;
import ru.test.danil.newsviwer.view.fragments.NewsListFragment;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public class NewsPresenter implements IPresenter {

    private static final String BUNDLE_NEWS_LIST_KEY = "BUNDLE_NEWS_LIST_KEY";

    private IModel model = new Model();
    private Subscription subscription = Subscriptions.empty();
    private NewsListFragment view;

    private List<News> newsList;

    public NewsPresenter(NewsListFragment view) {
        this.view = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

        subscription = model.getNewsList()
                .subscribe(new Observer<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<News> news) {
                        if (news != null && !news.isEmpty()) {
                            newsList = news;
                            view.showList(newsList);
                        }
                    }
                });
    }

    @Override
    public void onStop()
    {
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void clickNews(News news){
        view.startNewsDetailFragment(news);
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(BUNDLE_NEWS_LIST_KEY, (Serializable) newsList);
    }
}
