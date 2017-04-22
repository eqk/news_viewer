package ru.test.danil.newsviwer.view;

import java.util.List;

import ru.test.danil.newsviwer.model.News;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public interface IView {
    void showList(List<News> newsList);
}
