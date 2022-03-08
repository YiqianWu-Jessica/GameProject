package uoft.csc207.thisisagame.game3;

import java.util.ArrayList;
import java.util.Collections;

import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game3Interactor {

  private Game3Presenter presenter;
  private PlayerManager playerManager;
  private Player player;

  // a table with data
  private ArrayList<String> table = new ArrayList<>();
  private String tableData[] = {
    "ring", "ring", "bomb", "bomb", "bomb", "crown", "crown", "ring", "diamond"
  };

  Game3Interactor(Game3Presenter presenter, PlayerManager playerManager) {
    this.presenter = presenter;
    this.playerManager = playerManager;
    player = this.playerManager.getCurrentPlayer();
    presenter.setHP(player.getHP());
    presenter.setScore(player.getScore());
    presenter.setBonus(player.getBonus());

    // Create quizArray from quizData.
    for (int i = 0; i < 9; i++) {
      table.add(tableData[i]);
    }

    // shuffle the table
    Collections.shuffle(table);
  }

  // check the player whether he has life or not
  void checkPlayerAlive() {
    if (player.isDead()) {
      player.reset();
      playerManager.saveToFile();
      presenter.loseGame();
    }
  }

  // if got diamond
  void ifDiamond() {
    presenter.onDiamond(); // show picture and remind words

    int Score = player.getScore();
    int currentScore = Score + 20;
    player.setScore(currentScore); // change player's score
    presenter.setScore(currentScore); // change player's score text which show in the game

    // set player to the next level
    player.setLevel(4);

    // win();
    playerManager.saveToFile();
    presenter.winGame();
  }

  //if got Crown
  void ifCrown(){
    presenter.onCrown();

    int bonus = player.getBonus();
    int currBonus = bonus + 1;

    int score = player.getScore();
    int currScore = score + bonus * 2;

    player.setBonus(currBonus);
    player.setScore(currScore);

    presenter.setBonus(currBonus);
    presenter.setScore(currScore);
  }

  // if got ring
  void ifRing(){
    presenter.onRing();

    int hp = player.getHP();
    int currHp = hp + 1;

    player.setHP(currHp);
    presenter.setHP(currHp);
  }

  //if got bomb
  void ifBomb(){
    presenter.onBomb();

    int hp = player.getHP();
    int currHp = hp - 1;

    player.setHP(currHp);
    presenter.setHP(currHp);

    checkPlayerAlive();
  }


  // check what is the button the player check
  public void checkValue(int key) {
    // when the player check one button he will get the treasure or treat behind the button
    String btnText = table.get(key);
    if (btnText.equals("diamond")) {
      ifDiamond();
    } else if (btnText.equals("crown")) {
      ifCrown();
    } else if (btnText.equals("ring")) {
      ifRing();
    } else if (btnText.equals("bomb")) {
      ifBomb();
    }
  }
}
