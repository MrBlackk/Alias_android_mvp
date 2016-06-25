package com.mrb.alias.rules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.rey.material.widget.Button;

import com.mrb.alias.R;
import com.mrb.alias.start.StartActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RulesActivity extends AppCompatActivity implements RulesView {

    @Bind(R.id.rules_btnBackToMenu)
    Button btnBackToMenu;


    private RulesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);

        presenter = new RulesPresenterImpl(this);
        runListeners();
    }

    /**
     * Run listeners on button click and etc.
     */
    protected void runListeners() {
        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackToMenuButtonClick();
            }
        });
    }

    /**
     * Navigate to main menu
     */
    @Override
    public void navigateToMenu() {
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
}
