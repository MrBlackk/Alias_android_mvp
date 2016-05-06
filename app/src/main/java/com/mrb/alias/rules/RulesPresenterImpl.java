package com.mrb.alias.rules;

/**
 * Created by chv on 06.05.2016.
 */
public class RulesPresenterImpl implements RulesPresenter {

    RulesView rulesView;

    public RulesPresenterImpl(RulesView rulesView) {
        this.rulesView = rulesView;
    }

    /**
     * On Back To Menu button click
     */
    @Override
    public void onBackToMenuButtonClick() {
        rulesView.navigateToMenu();
    }

    /**
     * On back button on device pressed
     */
    @Override
    public void onBackButtonPressed() {
        rulesView.navigateToMenu();
    }
}
