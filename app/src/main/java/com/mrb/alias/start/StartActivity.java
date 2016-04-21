package com.mrb.alias.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrb.alias.BuildConfig;
import com.mrb.alias.R;
import com.mrb.alias.team.TeamActivity;
import com.mrb.alias.utils.SharedPreference;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements StartView {

    @Bind(R.id.start_btnNewGame)
    Button btnNewGame;

    @Bind(R.id.start_btnRules)
    Button btnRules;

    @Bind(R.id.start_btnExit)
    Button btnExit;

    @Bind(R.id.start_tvVersion)
    TextView tvVersion;

    private StartPresenter presenter;
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new StartPresenterImpl(this);
        this.runListeners();

        //Debug mode only
        String version = getString(R.string.start_version) + BuildConfig.VERSION_NAME;
        tvVersion.setText(version);
    }

    protected void runListeners() {
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNewGameButtonClick();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onExitButtonClick();
            }
        });
        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRulesButtonClick();
            }
        });
    }

    @Override
    public void navigateToTeam() {
        startActivity(new Intent(this, TeamActivity.class));
        finish();
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    public void showRules() {
        Toast.makeText(getApplicationContext(),"There are no rules!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void clearPreferences() {
        sharedPreference.clearPreferences(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
