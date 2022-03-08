package uoft.csc207.thisisagame.game2.game2units;

public abstract class Items {
  protected int x, y;
  int frameHeight, screenWidth;
  protected int size;
  // score change when hit
  int score;
  // hp change when hit
  int HP;
  // bonus change when hit
  int bonus;

  Items(int x, int y, int frameHeight, int screenWidth, int size) {
    this.x = x;
    this.y = y;
    this.frameHeight = frameHeight;
    this.screenWidth = screenWidth;
    this.size = size;
  }

  public abstract void move();

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  void setY(int y) {
    this.y = y;
  }

  public int getCentreX() {
    return x + size / 2;
  }

  public int getCentreY() {
    return y + size / 2;
  }

  public int getScore() {
    return score;
  }

  public int getHP() {
    return HP;
  }

  public int getBonus() {
    return bonus;
  }
}
