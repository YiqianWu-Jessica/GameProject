package uoft.csc207.thisisagame.game2.game2units;

public class Box extends Items {

  public Box(int x, int y, int frameHeight, int screenWidth, int size) {
    super(x, y, frameHeight, screenWidth, size);
  }

  @Override
  public void move() {
    x = 700;
    y = 800;
  }
}
