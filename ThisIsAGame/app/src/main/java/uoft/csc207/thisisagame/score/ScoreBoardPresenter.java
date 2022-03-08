package uoft.csc207.thisisagame.score;

import android.content.Context;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class ScoreBoardPresenter {

  private ScoreBoardView scoreBoardView;
  private ScoreBoardInteractor scoreBoardInteractor;
  private PlayerManager playerManager;

  ScoreBoardPresenter(ScoreBoardView scoreBoardView, PlayerManager playerManager, Context context) {
    this.scoreBoardView = scoreBoardView;
    scoreBoardInteractor = new ScoreBoardInteractor(this, playerManager, context);
  }

  void setRanks(String scoreRank, String hpRank, String bonusRank) {
    scoreBoardView.setRanks(scoreRank, hpRank, bonusRank);
  }
}
