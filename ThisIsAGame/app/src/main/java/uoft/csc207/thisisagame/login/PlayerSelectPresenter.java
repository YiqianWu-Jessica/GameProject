package uoft.csc207.thisisagame.login;

import android.content.Context;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class PlayerSelectPresenter {
  private PlayerSelectView playerSelectView;
  private PlayerSelectInteractor playerSelectInteractor;
  private PlayerManager playerManager;

  PlayerSelectPresenter(PlayerSelectView playerSelectView, String username, Context context) {
    this.playerSelectView = playerSelectView;
    playerSelectInteractor = new PlayerSelectInteractor(this, username, context);
    playerSelectView.setPlayerManager(playerManager);
  }

  // interactor call
  void setPlayerManager(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  void setPlayer1(String player1Name) {
    playerSelectView.setPlayer1(player1Name);
  }

  void setPlayer2(String player2Name) {
    playerSelectView.setPlayer2(player2Name);
  }

  void setPlayer3(String player3Name) {
    playerSelectView.setPlayer3(player3Name);
  }

  void navigateToGame1() {
    playerSelectView.navigateToGame1();
  }

  void navigateToGame2() {
    playerSelectView.navigateToGame2();
  }

  void navigateToGame3() {
    playerSelectView.navigateToGame3();
  }

  void navigateToScoreBoard() {
    playerSelectView.navigateToScoreBoard();
  }

  void onEmptyPlayerNameError() {
    playerSelectView.setEmptyPlayerNameError();
  }

  void onTooManyPlayersError() {
    playerSelectView.setTooManyPlayersError();
  }

  void removePlayer1() {
    playerSelectInteractor.removePlayer1();
  }

  void removePlayer2() {
    playerSelectInteractor.removePlayer2();
  }

  void removePlayer3() {
    playerSelectInteractor.removePlayer3();
  }

  void startGame(String currentPlayerName) {
    playerSelectInteractor.startGame(currentPlayerName);
  }
}
