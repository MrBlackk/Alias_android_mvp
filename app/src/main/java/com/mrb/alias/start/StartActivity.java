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

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements StartView {

    @Bind(R.id.button_new_game)
    Button newGameButton;

    @Bind(R.id.button_rules)
    Button rulesButton;

    @Bind(R.id.button_exit)
    Button exitButton;

    @Bind(R.id.textView_version)
    TextView textViewVersion;

    private StartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        presenter = new StartPresenterImpl(this);
        this.runListeners();

        //Debug mode only
        String version = getString(R.string.start_version) + BuildConfig.VERSION_NAME;
        textViewVersion.setText(version);
    }

    protected void runListeners() {
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNewGameButtonClick();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onExitButtonClick();
            }
        });
        rulesButton.setOnClickListener(new View.OnClickListener() {
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
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
