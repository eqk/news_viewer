package ru.test.danil.newsviwer.model;

import java.io.Serializable;

/**
 * Created by Krylov Danil on 21.04.2017.
 */

public class News implements Serializable {
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public News(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
