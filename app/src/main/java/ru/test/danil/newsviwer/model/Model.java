package ru.test.danil.newsviwer.model;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Krylov Danil on 21.04.2017.
 */

public class Model implements IModel {

    public static final int NEWS_PER_BLOCK = 10;
    @Override
    public Observable<List<News>> getNewsList()
    {
        return Observable.just(getList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<News> getList()
    {
        Faker f = new Faker();
        List<News> list = new ArrayList<News>();
        for (int i = 0; i < NEWS_PER_BLOCK; ++i) {
            list.add(new News(f.lorem().sentence(), f.lorem().paragraph()));
        }
        return list;
    }
}
