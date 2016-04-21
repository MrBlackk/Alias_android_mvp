package com.mrb.alias.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.results.ResultsActivity;
import com.mrb.alias.utils.SharedPreference;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity implements SettingsView{

    @Bind(R.id.settings_sbTime)
    SeekBar sbTime;

    @Bind(R.id.settings_tvTimeValue)
    TextView tvTimeValue;

    @Bind(R.id.settings_sbPoints)
    SeekBar sbPoints;

    @Bind(R.id.settings_tvPointsValue)
    TextView tvPointsValue;

    @Bind(R.id.settings_spnLevel)
    Spinner spnLevel;

    @Bind(R.id.settings_btnNext)
    Button btnNext;

    private SettingsPresenter presenter;
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new SettingsPresenterImpl(this);
        this.runListeners();

        sbTime.setProgress(10);
        sbPoints.setProgress(10);
    }

    protected void runListeners(){
        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekStep = 10;
                progress = Math.round(progress / seekStep) * seekStep;
                seekBar.setProgress(progress);
                tvTimeValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbPoints.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekStep = 10;
                progress = Math.round(progress / seekStep) * seekStep;
                seekBar.setProgress(progress);
                tvPointsValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextButtonClick();
            }
        });
    }

    @Override
    public int getTimeOnRound() {
        return sbTime.getProgress();
    }

    @Override
    public int getPointsOnRound() {
        return sbPoints.getProgress();
    }

    @Override
    public String getLevelValue() {
        return String.valueOf(spnLevel.getSelectedItem());
    }

    @Override
    public void navigateToResults() {
        startActivity(new Intent(this, ResultsActivity.class));
        finish();
    }

    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }
}
