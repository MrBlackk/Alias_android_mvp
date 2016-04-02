package com.mrb.alias.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mrb.alias.R;
import com.mrb.alias.game.GameActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamView{

    @Bind(R.id.button_start_game)
    Button buttonStartGame;

    private TeamPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        ButterKnife.bind(this);

        presenter = new TeamPresenterImpl(this);
        this.runListeners();
    }

    private void runListeners() {
        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartGameClick();
            }
        });
    }

    @Override
    public void navigateToGame() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
