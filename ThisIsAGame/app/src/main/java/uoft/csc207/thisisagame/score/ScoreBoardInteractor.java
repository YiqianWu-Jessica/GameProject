package uoft.csc207.thisisagame.score;

import android.content.Context;
import java.util.ArrayList;

import uoft.csc207.thisisagame.userdata.AccountManager;
import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class ScoreBoardInteractor {

  private ScoreBoardPresenter presenter;

  private String scoreRank, hpRank, bonusRank;
  private PlayerManager playerManager;
  private Player player;
  private Context context;

  ScoreBoardInteractor(
      ScoreBoardPresenter presenter, PlayerManager playerManager, Context context) {
    this.presenter = presenter;
    this.playerManager = playerManager;
    player = this.playerManager.getCurrentPlayer();
    this.context = context;
    getRanks();
    presenter.setRanks(scoreRank, hpRank, bonusRank);
  }

  // get ranks and saved locally
  private void getRanks() {
    // generate a list of all user names from file
    AccountManager accountManager = new AccountManager(context);
    ArrayList<String> usernameList = accountManager.getUsernameList();

    // generate a list of all players from file
    ArrayList<Player> allPlayersList = new ArrayList<>();
    for (String username : usernameList) {
      PlayerManager playerManager = new PlayerManager(context, username);
      allPlayersList.addAll(playerManager.getPlayerList());
    }
    // set rank strings
    setScoreRank(allPlayersList);
    setBonusRank(allPlayersList);
    setHpRank(allPlayersList);
  }

  // set data in to each ranks
  private void setScoreRank(ArrayList<Player> allPlayersList) {
    ArrayList<Player> tempList = new ArrayList<>();
    // add all the playerList item into the tempList
    for (int i = 0; i < allPlayersList.size(); i++) {
      tempList.add(allPlayersList.get(i));
    }

    // change the player's score order let the higher one be the first
    // put the player into the tempList in score high to low order
    for (int i = tempList.size() - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        int currentS = tempList.get(j).getScore();
        int nextS = tempList.get(j + 1).getScore();
        if (nextS >= currentS) {
          Player tempPlayer = tempList.get(j);
          tempList.set(j, tempList.get(j + 1));
          tempList.set(j + 1, tempPlayer);
        }
      }
    }

    // put the player's score in to the scoreRank in high to low order
    scoreRank = "";
    for (int i = 0; i < tempList.size(); i++) {
      Player currentP = tempList.get(i);
      int rank = i + 1;
      scoreRank =
          scoreRank + rank + ": " + currentP.getPlayername() + " " + currentP.getScore() + " \n";
    }
  }

  private void setBonusRank(ArrayList<Player> allPlayersList) {
    // add all the playerList item into the tempList
    ArrayList<Player> tempList = new ArrayList<>();
    for (int i = 0; i < allPlayersList.size(); i++) {
      tempList.add(allPlayersList.get(i));
    }
    // change the player's bonus order let the higher one be the first
    // put the player into the tempList in bonus mark high to low order
    for (int i = tempList.size() - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        int currentB = tempList.get(j).getBonus();
        int nextB = tempList.get(j + 1).getBonus();
        if (nextB >= currentB) {
          Player tempPlayer = tempList.get(j);
          tempList.set(j, tempList.get(j + 1));
          tempList.set(j + 1, tempPlayer);
        }
      }
    }
    // put the player's bonus in to the bonusRank in high to low order
    bonusRank = "";
    for (int i = 0; i < tempList.size(); i++) {
      Player currentP = tempList.get(i);
      int rank = i + 1;
      bonusRank =
          bonusRank + rank + ": " + currentP.getPlayername() + " " + currentP.getBonus() + " \n";
    }
  }

  private void setHpRank(ArrayList<Player> allPlayersList) {
    // add all the playerList item into the tempList
    ArrayList<Player> tempList = new ArrayList<>();
    for (int i = 0; i < allPlayersList.size(); i++) {
      tempList.add(allPlayersList.get(i));
    }
    // change the player's HP order let the higher one be the first
    // put the player into the tempList in HP mark high to low order
    for (int i = tempList.size() - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        int currentH = tempList.get(j).getHP();
        int nextH = tempList.get(j + 1).getHP();
        if (nextH >= currentH) {
          Player tempPlayer = tempList.get(j);
          tempList.set(j, tempList.get(j + 1));
          tempList.set(j + 1, tempPlayer);
        }
      }
    }
    // put the player's HP in to the HpRank in high to low order
    hpRank = "";
    for (int i = 0; i < tempList.size(); i++) {
      Player currentP = tempList.get(i);
      int rank = i + 1;
      hpRank = hpRank + rank + ": " + currentP.getPlayername() + " " + currentP.getHP() + " \n";
    }
  }
}
