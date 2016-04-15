package com.mrb.alias.game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.utils.DataBaseHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements GameView{

    @Bind(R.id.textView5)
    TextView tvWord;

    GamePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        presenter = new GamePresenterImpl(this);

        presenter.getRandomWord();
    }

    @Override
    public void showWord(String word) {
        tvWord.setText(word);
    }

    @Override
    public DataBaseHelper getDataBaseHelper() {
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);
        return myDbHelper;
    }
}
