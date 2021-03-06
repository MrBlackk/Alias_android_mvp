package com.mrb.alias.game;

import android.content.Intent;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.round.RoundActivity;
import com.mrb.alias.start.StartActivity;
import com.mrb.alias.utils.DataBaseHelper;
import com.mrb.alias.utils.SharedPreference;
import com.rey.material.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements GameView {

    @Bind(R.id.game_tvWord)
    TextView tvWord;

    @Bind(R.id.game_tvTimer)
    TextView tvTimer;

    @Bind(R.id.game_btnPlus)
    Button btnPlus;

    @Bind(R.id.game_btnMinus)
    Button btnMinus;

    GamePresenter presenter;
    DataBaseHelper dataBaseHelper;
    private CountDownTimer countDownTimer;
    private SharedPreference sharedPreference;

    /**
     * On create activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        dataBaseHelper = new DataBaseHelper(this);
        try {
            dataBaseHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        presenter = new GamePresenterImpl(this, dataBaseHelper);
        runListeners();

        presenter.onStart();
    }

    /**
     * Run listeners on button click and etc.
     */
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

    /**
     * Show word
     */
    @Override
    public void showWord(String word) {
        tvWord.setText(word);
    }

    /**
     * Start timer
     */
    @Override
    public void startTimer(int time) {
        countDownTimer = new CountDownTimer(time * 1000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf((int) Math.ceil(millisUntilFinished / 1000.0)));
            }

            @Override
            public void onFinish() {
                presenter.onTimeFinished();
            }
        }.start();
    }

    /**
     * Navigate to Round activity
     */
    @Override
    public void navigateToRoundResults() {
        startActivity(new Intent(this, RoundActivity.class));
        finish();
    }

    /**
     * Back to Menu activity
     */
    @Override
    public void backToMenu() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    /**
     * Load Game
     */
    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    /**
     * Save Game
     */
    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

    /**
     * Set text color red
     */
    @Override
    public void setTextRed() {
        tvWord.setTextColor(Color.RED);
    }

    @Override
    public void hideTimer() {
        tvTimer.setVisibility(View.GONE);
    }

    /**
     * On Back button pressed
     */
    @Override
    public void onBackPressed() {
        presenter.onBackButtonPressed();
    }
}
