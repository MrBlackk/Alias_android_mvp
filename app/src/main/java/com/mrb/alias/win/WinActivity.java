package com.mrb.alias.win;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.results.Game;
import com.mrb.alias.utils.SharedPreference;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WinActivity extends AppCompatActivity implements WinView {

    @Bind(R.id.textViewWinner)
    TextView tvWinner;

    private SharedPreference sharedPreference;
    private WinPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference();

        presenter = new WinPresenterImpl(this);
        presenter.getWinner();
    }

    @Override
    public void showWinner(String winner) {
        tvWinner.setText(winner);
    }

    @Override
    public Game loadGame() {
        return sharedPreference.loadGame(this);
    }

    @Override
    public void saveGame(Game game) {
        sharedPreference.saveGame(this,game);
    }
}
