package uoft.csc207.thisisagame.game2.game2units;

public class Starfish extends Items {

  public Starfish(int x, int y, int frameHeight, int screenWidth, int size) {
    super(x, y, frameHeight, screenWidth, size);
    HP = 1;
  }

  // override the method let starfish move
  @Override
  public void move() {
    x -= 25;
    if (x < 0) {
      y = (int) Math.floor(Math.random() * (frameHeight - size));
      x = screenWidth + 50;
    }
  }
}
