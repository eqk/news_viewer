package ru.test.danil.newsviwer.model;

import java.util.List;

import rx.Observable;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public interface IModel {
    Observable<List<News>> getNewsList();
}
