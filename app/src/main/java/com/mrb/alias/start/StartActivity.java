package com.mrb.alias.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mrb.alias.R;
import com.mrb.alias.settings.SettingsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements StartView{

    @Bind(R.id.button_new_game)
    Button newGameButton;

    private StartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        presenter = new StartPresenterImpl(this);
        this.runListeners();
    }

    public void runListeners(){
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNewGameButtonClick();
            }
        });
    }

    @Override
    public void navigateToSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
        finish();
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
