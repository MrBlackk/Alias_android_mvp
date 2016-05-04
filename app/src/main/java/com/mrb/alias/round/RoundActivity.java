package com.mrb.alias.round;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.results.ResultsActivity;
import com.mrb.alias.start.StartActivity;
import com.mrb.alias.utils.SharedPreference;
import com.mrb.alias.win.WinActivity;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RoundActivity extends AppCompatActivity implements RoundView {

    @Bind(R.id.round_lvWords)
    ListView lvWords;

    @Bind(R.id.round_btnNext)
    Button btnNext;

    private SharedPreference sharedPreference;
    private RoundPresenter presenter;


    /**
     * On create activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new RoundPresenterImpl(this);
        runListeners();

        presenter.onStart();
    }

    /**
     * Run listeners on button click and etc.
     */
    protected void runListeners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextButtonClick();
            }
        });
    }


    /**
     * Load game
     */
    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    /**
     * Navigate to Results activity
     */
    @Override
    public void navigateToResults() {
        startActivity(new Intent(this, ResultsActivity.class));
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
     * Navigate to Win activity
     */
    @Override
    public void navigateToWin() {
        startActivity(new Intent(this, WinActivity.class));
        finish();
    }

    /**
     * Show list of words
     */
    @Override
    public void showListOfWords(HashMap<String, Boolean> words) {
        WordsResultAdapter adapter = new WordsResultAdapter(words);
        lvWords.setAdapter(adapter);
    }

    /**
     * Save game
     */
    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

    /**
     * On Back button pressed
     */
    @Override
    public void onBackPressed() {
        presenter.onBackButtonPressed();
    }
}
