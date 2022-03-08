package uoft.csc207.thisisagame.game3;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game3Presenter {
  private Game3Interactor game3Interactor;
  private Game3View game3View;

  // check View message
  Game3Presenter(Game3View game3View, PlayerManager playerManager) {
    this.game3View = game3View;
    game3Interactor = new Game3Interactor(this, playerManager);
  }

  void setHP(int hp) {
    game3View.setHp(hp);
  };

  void setBonus(int bonus) {
    game3View.setBonus(bonus);
  };

  void setScore(int score) {
    game3View.setScore(score);
  }

  void loseGame() {
    game3View.lose();
  }

  void winGame() {
    game3View.win();
  }

  // when player check the diamond
  void onDiamond() {
    game3View.clickDiamond();
  }

  // when player got the ring
  void onRing() {
    game3View.clickRing();
  }

  // when player has the crown
  void onCrown() {
    game3View.clickCrown();
  }

  // when player check the bomb
  void onBomb() {
    game3View.clickBomb();
  }

  // check what's behind the button which the player click
  void checkValue(int key) {
    game3Interactor.checkValue(key);
  }
}
