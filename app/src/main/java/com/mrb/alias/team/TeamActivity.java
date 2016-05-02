package com.mrb.alias.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.settings.SettingsActivity;
import com.mrb.alias.start.StartActivity;
import com.mrb.alias.utils.SharedPreference;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamView {

    @Bind(R.id.team_btnNext)
    Button btnNext;

    @Bind(R.id.team_lvTeams)
    ListView lvTeams;

    private TeamPresenter presenter;
    private SharedPreference sharedPreference;

    /**
     * On create activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new TeamPresenterImpl(this);
        this.runListeners();

        presenter.onStart();
    }

    /**
     * Run listeners on button click and etc.
     */
    private void runListeners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextButtonClick();
            }
        });
    }

    /**
     * Navigate to Settings activity
     */
    @Override
    public void navigateToSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
        finish();
    }

    /**
     * Back to start screen
     */
    @Override
    public void backToStart() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    /**
     * Show list of teams via adapter
     *
     * @param arrayOfTeams    - array of Team elements
     * @param isPointsVisible - show points next to team name or not
     */
    @Override
    public void showListOfTeams(ArrayList<Team> arrayOfTeams, boolean isPointsVisible) {
        TeamAdapter adapter = new TeamAdapter(this, arrayOfTeams, isPointsVisible);
        lvTeams.setAdapter(adapter);
    }

    /**
     * Load game
     *
     * @return Game class
     */
    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    /**
     * Save game to Shared Preferences
     *
     * @param game - Game class
     */
    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

    /**
     * On back button pressed
     */
    @Override
    public void onBackPressed() {
        presenter.onBackButtonPressed();
    }
}
