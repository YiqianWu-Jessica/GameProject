package uoft.csc207.thisisagame.game2;

import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game2Presenter {
  private Game2View g2View;
  private Game2Interactor g2Interactor;

  Game2Presenter(Game2View g2View, PlayerManager playerManager, Game2Data data) {
    this.g2View = g2View;
    g2Interactor = new Game2Interactor(this, playerManager, data);
  }

  void clickStart() {
    g2Interactor.clickStart();
  }

  void clickLeft() {
    g2Interactor.clickLeft();
  }

  void clickRight() {
    g2Interactor.clickRight();
  }

  void clickUp() {
    g2Interactor.clickUp();
  }

  void clickDown() {
    g2Interactor.clickDown();
  }

  void clickPause() {
    g2Interactor.clickPause();
  }

  void setFishPos(int x, int y) {
    g2View.setFishPos(x, y);
  }

  void setStarFishPos(int x, int y) {
    g2View.setStarFishPos(x, y);
  }

  void setBoxPos(int x, int y) {
    g2View.setBoxPos(x, y);
  }

  void setJellyPos(int x, int y) {
    g2View.setJellyPos(x, y);
  }

  void setSharkPos(int x, int y) {
    g2View.setSharkPos(x, y);
  }

  void setBoatPos(float x, float y) {
    g2View.setBoatPos(x, y);
  }

  void setScoreLabel(int score) {
    g2View.setScoreLabel(score);
  }

  void setHPLabel(int hp) {
    g2View.setHPLabel(hp);
  }

  void setBonusLabel(int bonus) {
    g2View.setBonusLabel(bonus);
  }

  void onPause() {
    g2View.setPause();
  }

  void onResume() {
    g2View.setResume();
  }

  void win() {
    g2View.win();
  }

  void lose() {
    g2View.lose();
  }

  void playWinSound() {
    g2View.playWinSound();
  }

  void playLoseSound() {
    g2View.playLoseSound();
  }

  void playGetSound() {
    g2View.playGetSound();
  }
}
