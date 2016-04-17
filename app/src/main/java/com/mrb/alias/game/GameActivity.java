package com.mrb.alias.game;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.round.RoundActivity;
import com.mrb.alias.utils.DataBaseHelper;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements GameView{

    @Bind(R.id.textViewWord)
    TextView tvWord;

    @Bind(R.id.tVtimer)
    TextView tvTimer;

    @Bind(R.id.buttonPlus)
    Button btnPlus;

    @Bind(R.id.buttonMinus)
    Button btnMinus;

    GamePresenter presenter;
    DataBaseHelper dataBaseHelper;
    private CountDownTimer countDownTimer;

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
        presenter.startTimer();
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

    @Override
    public void startTimer(int time) {
        countDownTimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                presenter.onTimeFinished();
            }
        }.start();
    }

    @Override
    public void navigateToRoundResults() {
        startActivity(new Intent(this, RoundActivity.class));
        finish();
    }

}
