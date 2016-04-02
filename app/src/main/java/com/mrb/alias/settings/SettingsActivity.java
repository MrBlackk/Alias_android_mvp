package com.mrb.alias.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.mrb.alias.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    @Bind(R.id.seekBar)
    SeekBar timeSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);



    }

}
