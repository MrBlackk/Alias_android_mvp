package com.mrb.alias.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mrb.alias.R;
import com.mrb.alias.settings.SettingsActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamView{

    @Bind(R.id.button_next_to_settings)
    Button buttonNextToSettings;

    @Bind(R.id.listViewTeams)
    ListView lvTeams;

    private TeamPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        ButterKnife.bind(this);

        presenter = new TeamPresenterImpl(this);
        this.runListeners();


        presenter.createTeams();
    }

    private void runListeners() {
        buttonNextToSettings.setOnClickListener(new View.OnClickListener() {
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
    public void showListOfUsers(ArrayList<Team> arrayOfTeams) {
        TeamAdapter adapter = new TeamAdapter(this, arrayOfTeams, false);
        lvTeams.setAdapter(adapter);
    }
}
