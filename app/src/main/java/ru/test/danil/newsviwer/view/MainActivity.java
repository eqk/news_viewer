package ru.test.danil.newsviwer.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ru.test.danil.newsviwer.R;
import ru.test.danil.newsviwer.model.News;
import ru.test.danil.newsviwer.presenter.IPresenter;
import ru.test.danil.newsviwer.presenter.NewsPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;
import ru.test.danil.newsviwer.view.fragments.NewsDetailFragment;
import ru.test.danil.newsviwer.view.fragments.NewsListFragment;

public class MainActivity extends AppCompatActivity implements IView {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_news_list);
        if (fragment == null){
            replaceFragment(new NewsListFragment(), false);
        }
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    public void startNewsDetailFragment(News news){
        replaceFragment(NewsDetailFragment.newInstance(news), true);
    }
}
