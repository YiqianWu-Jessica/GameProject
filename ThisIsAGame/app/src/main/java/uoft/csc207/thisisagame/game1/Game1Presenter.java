package uoft.csc207.thisisagame.game1;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game1Presenter {
  private Game1Interactor game1Interactor;
  private Game1View game1View;

  Game1Presenter(Game1View game1View, PlayerManager playerManager) {
    this.game1View = game1View;
    game1Interactor = new Game1Interactor(this, playerManager);
  }

  void getCheckAnswer(String input) {
    game1Interactor.checkAnswer(input);
  }

  void right() {
    game1View.win();
  }

  void wrong() {
    game1View.wrong();
  }

  void correct() {
    game1View.correct();
  }

  void lose() {
    game1View.lose();
  }

  void setHP(int HP) {
    game1View.setHP(Integer.toString(HP));
  }

  void setScore(int Score) {
    game1View.setScore(Integer.toString(Score));
  }

  void setBonus(int Bonus) {
    game1View.setBonus(Integer.toString(Bonus));
  }

  void toSecondQestion() {
    game1View.toSecondQuestion();
  }

  void toThirdQestion() {
    game1View.toThirdQuestion();
  }

  void toFouthQestion() {
    game1View.toFourthQuestion();
  }

  void toFifthQestion() {
    game1View.toFifthQuestion();
  }
}
