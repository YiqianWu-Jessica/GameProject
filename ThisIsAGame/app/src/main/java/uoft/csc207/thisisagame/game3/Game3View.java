package uoft.csc207.thisisagame.game3;

interface Game3View {
  void win();

  void lose();

  void setHp(int hp);

  void setBonus(int bonus);

  void setScore(int score);

  void clickDiamond();

  void clickCrown();

  void clickBomb();

  void clickRing();
}
