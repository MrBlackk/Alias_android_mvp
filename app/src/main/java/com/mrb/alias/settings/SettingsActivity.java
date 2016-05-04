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
import com.mrb.alias.start.StartActivity;
import com.mrb.alias.utils.SharedPreference;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity implements SettingsView {

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

    /**
     * On create activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new SettingsPresenterImpl(this);
        this.runListeners();

        presenter.onStart();
    }

    /**
     * Run listeners on button click and etc.
     */
    protected void runListeners() {
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

    /**
     * Get Time on Round seek bar value
     */
    @Override
    public int getTimeOnRound() {
        return sbTime.getProgress();
    }

    /**
     * Get Points to win seek bar value
     */
    @Override
    public int getPointsOnRound() {
        return sbPoints.getProgress();
    }

    /**
     * Get drop down Level value
     */
    @Override
    public String getLevelValue() {
        return String.valueOf(spnLevel.getSelectedItem());
    }

    /**
     * Navigate to Results activity
     */
    @Override
    public void navigateToResults() {
        startActivity(new Intent(this, ResultsActivity.class));
        finish();
    }

    /**
     * Back to menu screen
     */
    @Override
    public void backToMenu() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    /**
     * On back button pressed
     */
    @Override
    public void onBackPressed() {
        presenter.onBackButtonPressed();
    }

    /**
     * Load game
     */
    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    /**
     * Save game to Shared Preferences
     */
    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this, game);
    }

    /**
     * Set value to Time seek bar
     */
    @Override
    public void setTimeSeekBarProgress(int progress) {
        sbTime.setProgress(progress);
    }

    /**
     * Set value to Points seek bar
     */
    @Override
    public void setPointsSeekBarProgress(int progress) {
        sbPoints.setProgress(progress);
    }
}
