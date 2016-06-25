package com.mrb.alias.results;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.game.GameActivity;
import com.mrb.alias.start.StartActivity;
import com.mrb.alias.team.Team;
import com.mrb.alias.team.TeamAdapter;
import com.mrb.alias.utils.SharedPreference;
import com.rey.material.widget.Button;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity implements ResultsView {

    @Bind(R.id.results_lvResults)
    ListView lvResults;

    @Bind(R.id.results_btnStart)
    Button btnStart;

    @Bind(R.id.results_tvNextTeam)
    TextView tvNextTeam;

    @Bind(R.id.results_tvRound)
    TextView tvRound;

    private ResultsPresenter presenter;
    private SharedPreference sharedPreference;

    /**
     * On create activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new ResultsPresenterImpl(this);
        this.runListeners();

        presenter.onStart();
    }

    /**
     * Run listeners on button click and etc.
     */
    protected void runListeners() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClick();
            }
        });
    }

    /**
     * Show results, team name and points
     */
    @Override
    public void showResults(ArrayList<Team> arrayOfTeams, boolean isPointsVisible) {
        TeamAdapter adapter = new TeamAdapter(this, arrayOfTeams, isPointsVisible);
        lvResults.setAdapter(adapter);
    }

    /**
     * Show next team
     */
    @Override
    public void showNextTeam(String teamName) {
        tvNextTeam.setText(teamName);
    }

    /**
     * Show current game round
     */
    @Override
    public void showRound(int round) {
        tvRound.setText(String.valueOf(round));
    }

    /**
     * Navigate to Game activity
     */
    @Override
    public void navigateToGame() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }

    /**
     * Back to Menu screen
     */
    @Override
    public void backToMenu() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    /**
     * Save Game
     */
    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

    /**
     * Load game
     */
    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    /**
     * On back button pressed
     */
    @Override
    public void onBackPressed() {
        presenter.onBackButtonPressed();
    }
}
