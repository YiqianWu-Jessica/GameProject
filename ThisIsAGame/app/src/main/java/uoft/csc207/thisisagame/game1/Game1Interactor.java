package uoft.csc207.thisisagame.game1;

import java.util.ArrayList;

import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game1Interactor {
  private Game1Presenter presenter;
  private PlayerManager playerManager;
  private ArrayList<String> answerList = new ArrayList<>(5);
  private Player player;
  // level inside the game 1
  // each level has a guessing question
  private int level = 0;

  Game1Interactor(Game1Presenter presenter, PlayerManager playerManager) {
    this.presenter = presenter;
    this.playerManager = playerManager;
    player = this.playerManager.getCurrentPlayer();
    presenter.setHP(player.getHP());
    presenter.setScore(player.getScore());
    presenter.setBonus(player.getBonus());
    answerList.add("fish");
    answerList.add("turtle");
    answerList.add("bomb");
    answerList.add("jellyfish");
    answerList.add("y");
  }

  // take next question only if get the answer correct
  void checkAnswer(String input) {

    if (answerList.get(level).equals(input)) {
      presenter.correct();
      player.setScore(player.getScore() + 10);
      level++;
      presenter.setScore(player.getScore());
      if (level == 1) {
        presenter.toSecondQestion();
      } else if (level == 2) {
        presenter.toThirdQestion();
      } else if (level == 3) {
        presenter.toFouthQestion();
      } else if (level == 4) {
        presenter.toFifthQestion();
      } else if (level == 5) {
          // player get 2 bonus for correct answer "why"
        player.setBonus(player.getBonus() + 2);
        player.setLevel(2);
        playerManager.saveToFile();
        presenter.right();
      }
    } else {
        // if player got wrong at bonus question do not need to loss hp.
      if (level == 4) {
        player.setLevel(2);
        playerManager.saveToFile();
        presenter.right();
      } else {
        player.setHP(player.getHP() - 1);
        presenter.setHP(player.getHP());
      }
      if (player.isDead()) {
        player.reset();
        playerManager.saveToFile();
        presenter.lose();
      } else {
        presenter.wrong();
      }
    }
  }
}
