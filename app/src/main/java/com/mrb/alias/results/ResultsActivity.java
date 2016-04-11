package com.mrb.alias.results;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mrb.alias.R;
import com.mrb.alias.game.GameActivity;
import com.mrb.alias.team.Team;
import com.mrb.alias.team.TeamAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity implements ResultsView{

    @Bind(R.id.listViewResults)
    ListView lvResults;

    @Bind(R.id.button_results_start)
    Button buttonStart;

    private ResultsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        presenter = new ResultsPresenterImpl(this);
        presenter.getResults();

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
    public void navigateToGame() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
