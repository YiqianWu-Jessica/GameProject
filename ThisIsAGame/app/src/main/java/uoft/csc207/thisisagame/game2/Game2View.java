package uoft.csc207.thisisagame.game2;

public interface Game2View {
  void setFishPos(int x, int y);

  void setStarFishPos(int x, int y);

  void setBoxPos(int x, int y);

  void setJellyPos(int x, int y);

  void setSharkPos(int x, int y);

  void setBoatPos(float x, float y);

  void setScoreLabel(int score);

  void setHPLabel(int hp);

  void setBonusLabel(int bonus);

  void setPause();

  void setResume();

  void win();

  void lose();

  void playLoseSound();

  void playWinSound();

  void playGetSound();
}
