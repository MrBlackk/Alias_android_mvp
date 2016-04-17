package com.mrb.alias.results;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.game.GameActivity;
import com.mrb.alias.team.Team;
import com.mrb.alias.team.TeamAdapter;
import com.mrb.alias.utils.SharedPreference;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity implements ResultsView{

    @Bind(R.id.listViewResults)
    ListView lvResults;

    @Bind(R.id.button_results_start)
    Button buttonStart;

    @Bind(R.id.textViewNextTeam)
    TextView tvNextTeam;

    @Bind(R.id.textViewRound)
    TextView tvNextRound;

    private ResultsPresenter presenter;
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new ResultsPresenterImpl(this);
        presenter.getResults();
        presenter.startGame();
        presenter.getNextTeam();
        presenter.getRound();

        this.runListeners();
    }

    protected void runListeners() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClick();
            }
        });
    }

    @Override
    public void showResults(ArrayList<Team> arrayOfTeams) {
        TeamAdapter adapter = new TeamAdapter(this, arrayOfTeams, true);
        lvResults.setAdapter(adapter);
    }

    @Override
    public void showNextTeam(String teamName) {
        tvNextTeam.setText(teamName);
    }

    @Override
    public void showRound(int round) {
        tvNextRound.setText(String.valueOf(round));
    }

    @Override
    public void navigateToGame() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }

    @Override
    public ArrayList<Team> getTeams() {
        return sharedPreference.getTeams(this);
    }

    @Override
    public void saveTeams(ArrayList<Team> arrayList) {
        sharedPreference.saveTeams(this,arrayList);
    }

    @Override
    public int getSettingsTime() {
        return sharedPreference.getTime(this);
    }

    @Override
    public void saveGame(GameSingleton game) {
        sharedPreference.saveGame(this, game);
    }
}
