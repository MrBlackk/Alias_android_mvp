package com.mrb.alias.game;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.utils.DataBaseHelper;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements GameView{

    @Bind(R.id.textViewWord)
    TextView tvWord;

    @Bind(R.id.buttonPlus)
    Button btnPlus;

    @Bind(R.id.buttonMinus)
    Button btnMinus;

    GamePresenter presenter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        dataBaseHelper = new DataBaseHelper(this);
        try {
            dataBaseHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dataBaseHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        presenter = new GamePresenterImpl(this, dataBaseHelper);

        presenter.getRandomWord();
        runListeners();
    }

    private void runListeners() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPlusButtonClick();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMinusButtonClick();
            }
        });
    }

    @Override
    public void showWord(String word) {
        tvWord.setText(word);
    }

}
