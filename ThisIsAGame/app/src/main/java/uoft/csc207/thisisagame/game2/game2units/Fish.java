package uoft.csc207.thisisagame.game2.game2units;

public class Fish extends Items {

  public Fish(int x, int y, int frameHeight, int screenWidth, int size) {
    super(x, y, frameHeight, screenWidth, size);
    score = 20;
  }

  // override the method let fish move
  @Override
  public void move() {
    x -= 14;
    if (x < 0) {
      y = (int) Math.floor(Math.random() * (frameHeight - size));
      x = screenWidth + 25;
    }
  }
}
