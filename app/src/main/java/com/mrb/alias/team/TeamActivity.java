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
import com.mrb.alias.utils.SharedPreference;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamView{

    @Bind(R.id.team_btnNext)
    Button btnNext;

    @Bind(R.id.team_lvTeams)
    ListView lvTeams;

    private TeamPresenter presenter;
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new TeamPresenterImpl(this);
        this.runListeners();

        presenter.createTeams();
    }

    private void runListeners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextToSettingsClick();
            }
        });
    }

    @Override
    public void navigateToSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
        finish();
    }

    @Override
    public void showListOfTeams(ArrayList<Team> arrayOfTeams) {
        TeamAdapter adapter = new TeamAdapter(this, arrayOfTeams, false);
        lvTeams.setAdapter(adapter);
    }

    @Override
    public Game loadGame() {
       return sharedPreference.loadGame(this);
    }

    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this,game);
    }
}
