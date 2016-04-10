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
import com.mrb.alias.team.TeamActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity implements SettingsView{

    @Bind(R.id.seekBarTime)
    SeekBar timeSeekBar;

    @Bind(R.id.seekTimeValue)
    TextView valueTimeSeek;

    @Bind(R.id.seekBarPoints)
    SeekBar pointsSeekBar;

    @Bind(R.id.seekPointsValue)
    TextView valuePointsSeek;

    @Bind(R.id.spinner_level)
    Spinner levelSpinner;

    @Bind(R.id.button_go_game)
    Button buttonGoTeam;

    private SettingsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        presenter = new SettingsPresenterImpl(this);
        this.runListeners();

    }

    protected void runListeners(){
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekStep = 10;
                progress = Math.round(progress/seekStep) * seekStep;
                seekBar.setProgress(progress);
                valueTimeSeek.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        pointsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekStep = 10;
                progress = Math.round(progress/seekStep) * seekStep;
                seekBar.setProgress(progress);
                valuePointsSeek.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        buttonGoTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onGoButtonClick();
            }
        });
    }

    @Override
    public int getTimeOnRound() {
        return timeSeekBar.getProgress();
    }

    @Override
    public int getPointsOnRound() {
        return pointsSeekBar.getProgress();
    }

    @Override
    public String getLevelValue() {
        return String.valueOf(levelSpinner.getSelectedItem());
    }

    @Override
    public void navigateToTeam() {
        startActivity(new Intent(this, TeamActivity.class));
        finish();
    }
}
