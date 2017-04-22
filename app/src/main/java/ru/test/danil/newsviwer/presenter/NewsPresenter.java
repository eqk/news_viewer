package ru.test.danil.newsviwer.presenter;

import java.util.List;

import ru.test.danil.newsviwer.model.IModel;
import ru.test.danil.newsviwer.model.Model;

import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.view.IView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public class NewsPresenter implements IPresenter {

    private IModel model = new Model();
    private Subscription subscription = Subscriptions.empty();
    private IView view;

    public NewsPresenter(IView view) {
        this.view = view;
    }

    @Override
    public void onCreate()
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
                        if (news != null && !news.isEmpty()){
                            view.showList(news);
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
}
