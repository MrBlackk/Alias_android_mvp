package com.mrb.alias.win;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

/**
 * Created by chvs on 20.04.2016.
 */
public class WinPresenterImpl implements WinPresenter {

    WinView winView;
    Game game;

    public WinPresenterImpl(WinView winView) {
        this.winView = winView;
        game = this.winView.loadGame();
    }

    @Override
    public void getWinner() {
        Team winnerTeam = game.getCurrentTeam();
        String name = winnerTeam.getName();
        winView.showWinner(name);
    }
}
