package uoft.csc207.thisisagame.game1;

interface Game1View {
  void setHP(String hp);

  void setBonus(String bonus);

  void setScore(String score);

  void win();

  void lose();

  void correct();

  void wrong();

  void toSecondQuestion();

  void toThirdQuestion();

  void toFourthQuestion();

  void toFifthQuestion();
}
