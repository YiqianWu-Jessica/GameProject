package uoft.csc207.thisisagame.login;

import uoft.csc207.thisisagame.userdata.PlayerManager;

interface PlayerSelectView {

  void setPlayerManager(PlayerManager playerManager);

  void setPlayer1(String player1Name);

  void setPlayer2(String player2Name);

  void setPlayer3(String player3Name);

  void navigateToGame1();

  void navigateToGame2();

  void navigateToGame3();

  void navigateToScoreBoard();

  void setEmptyPlayerNameError();

  void setTooManyPlayersError();
}
