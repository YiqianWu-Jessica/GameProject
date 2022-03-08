package uoft.csc207.thisisagame.game2.game2units;

public class Jelly extends Items {

  public Jelly(int x, int y, int frameHeight, int screenWidth, int size) {
    super(x, y, frameHeight, screenWidth, size);
    bonus = 1;
  }

  // override the method let Jelly move
  @Override
  public void move() {
    x -= 20;
    if (x < 0) {
      y = (int) Math.floor(Math.random() * (frameHeight - size));
      x = screenWidth + 20;
    }
  }
}
