package uoft.csc207.thisisagame.login;

import android.content.Context;

import java.util.ArrayList;

import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class PlayerSelectInteractor {

  private PlayerSelectPresenter presenter;
  private PlayerManager playerManager;
  private String player1Name = "", player2Name = "", player3Name = "";

  PlayerSelectInteractor(PlayerSelectPresenter presenter, String username, Context context) {
    this.presenter = presenter;
    playerManager = new PlayerManager(context, username);
    presenter.setPlayerManager(playerManager);
    setPlayers();
  }

  // set up players and display on the UI
  private void setPlayers() {
    ArrayList<Player> playerList = playerManager.getPlayerList();
    if (playerList.size() >= 1) {
      player1Name = playerList.get(0).getPlayername();
    }
    if (playerList.size() >= 2) {
      player2Name = playerList.get(1).getPlayername();
    }
    if (playerList.size() == 3) {
      player3Name = playerList.get(2).getPlayername();
    }
    presenter.setPlayer1(player1Name);
    presenter.setPlayer2(player2Name);
    presenter.setPlayer3(player3Name);
  }

  void removePlayer1() {
    playerManager.removePlayer(player1Name);
  }

  void removePlayer2() {
    playerManager.removePlayer(player2Name);
  }

  void removePlayer3() {
    playerManager.removePlayer(player3Name);
  }

  void startGame(String currentPlayerName) {
    if (currentPlayerName.isEmpty()) {
      presenter.onEmptyPlayerNameError();
    } else if (!playerManager.playerIsInTheList(currentPlayerName)
        && playerManager.getNumberOfPlayers() == 3) {
      // for new player check if exceeds limit of the number of players for one user
      presenter.onTooManyPlayersError();
    } else if (playerManager.playerIsInTheList(currentPlayerName)) {
      // for existing player, set current player and proceed
      playerManager.setCurrentPlayer(currentPlayerName);
      navigation();
    } else {
      // for new player, add new player and proceed
      Player currentPlayer = new Player(currentPlayerName);
      playerManager.addPlayer(currentPlayer);
      playerManager.setCurrentPlayer(currentPlayer);
      navigation();
    }
  }

  // go to the current player's game level
  private void navigation() {
    int currentLevel = playerManager.getCurrentPlayer().getLevel();
    if (currentLevel == 1) {
      presenter.navigateToGame1();
    } else if (currentLevel == 2) {
      presenter.navigateToGame2();
    } else if (currentLevel == 3) {
      presenter.navigateToGame3();
    } else if (currentLevel == 4) {
      presenter.navigateToScoreBoard();
    }
  }
}
