package ru.test.danil.newsviwer.presenter;

import android.os.Bundle;

import ru.test.danil.newsviwer.model.News;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public interface IPresenter {
    void onCreate(Bundle savedInstanceState);
    void onStop();
    void clickNews(News news);
}
