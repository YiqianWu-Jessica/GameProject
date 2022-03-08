package uoft.csc207.thisisagame.result;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class WinPresenter {
  private WinView winView;
  private WinInteractor winInteractor;
  private PlayerManager playerManager;

  WinPresenter(WinView winView, PlayerManager playerManager) {
    this.winView = winView;
    this.winInteractor = new WinInteractor(this, playerManager);
  }

  void setPlayerManager(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  void buttonToNext() {
    winInteractor.buttonToNext();
  }

  void navigateToGame1() {
    winView.navigateToGame1();
  }

  void navigateToGame2() {
    winView.navigateToGame2();
  }

  void navigateToGame3() {
    winView.navigateToGame3();
  }

  void navigateToBoard() {
    winView.navigateToBoard();
  }

  void setScoreLabel(int score) {
    winView.setScoreLabel(score);
  }
}
