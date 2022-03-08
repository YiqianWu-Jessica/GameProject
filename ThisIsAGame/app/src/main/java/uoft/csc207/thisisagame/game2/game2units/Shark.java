package uoft.csc207.thisisagame.game2.game2units;

public class Shark extends Items {

  public Shark(int x, int y, int frameHeight, int screenWidth, int size) {
    super(x, y, frameHeight, screenWidth, size);
    HP = -1;
  }

  // override the method let shark move
  @Override
  public void move() {
    x -= 18;
    if (x < 0) {
      y = (int) Math.floor(Math.random() * (frameHeight - size));
      x = screenWidth + 10;
    }
  }
}
