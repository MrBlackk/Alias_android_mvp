package com.mrb.alias.round;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.utils.SharedPreference;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RoundActivity extends AppCompatActivity implements RoundView{

    @Bind(R.id.lvWords)
    ListView lvWords;

    private SharedPreference sharedPreference;
    private RoundPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new RoundPresenterImpl(this);
        presenter.getListOfWords();
    }


    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    @Override
    public void showListOfWords(HashMap<String, Boolean> words) {
        WordsResultAdapter adapter = new WordsResultAdapter(words);
        lvWords.setAdapter(adapter);
    }

    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

}
