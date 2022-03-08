package uoft.csc207.thisisagame.result;

import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class WinInteractor {
  private WinPresenter presenter;
  private PlayerManager playerManager;
  private Player player;

  WinInteractor(WinPresenter presenter, PlayerManager playerManager) {
    this.presenter = presenter;
    this.playerManager = playerManager;
    player = this.playerManager.getCurrentPlayer();
    setScoreLabel();
  }

  // after win the game then set to the next level
  void buttonToNext() {
    if (player.getLevel() == 1) {
      presenter.navigateToGame1();
    } else if (player.getLevel() == 2) {
      presenter.navigateToGame2();
    } else if (player.getLevel() == 3) {
      presenter.navigateToGame3();
    } else if (player.getLevel() == 4) {
      presenter.navigateToBoard();
    }
  }

  private void setScoreLabel() {
    presenter.setScoreLabel(player.getScore());
  }
}
