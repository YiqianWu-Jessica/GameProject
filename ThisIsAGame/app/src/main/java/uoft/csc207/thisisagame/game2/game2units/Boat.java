package uoft.csc207.thisisagame.game2.game2units;

public class Boat {
  // maxX,Y is the largest X,Y that the boat can reach
  int maxX, maxY;
  private int x, y;
  private int frameHeight, screenWidth, frameWidth, boatSize;

  public Boat(int x, int y, int frameHeight, int frameWidth, int screenWidth, int boatSize) {
    this.x = x;
    this.y = y;
    this.frameHeight = frameHeight;
    this.frameWidth = frameWidth;
    this.screenWidth = screenWidth;
    this.boatSize = boatSize;
    maxX = frameWidth - boatSize;
    maxY = frameHeight - boatSize;
  }

  public int getBoatSize() {
    return boatSize;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  private void moveCheck() {
    // check move restriction
    if (x < 0) x = 0;
    if (x > maxX) {
      x = maxX;
    }
    if (y < 0) y = 0;
    if (y > maxY) {
      y = maxY;
    }
  }

  public void moveLeft() {
    x -= 40;
    moveCheck();
  }

  public void moveRight() {
    x += 40;
    moveCheck();
  }

  public void moveUp() {
    y -= 40;
    moveCheck();
  }

  public void moveDown() {
    y += 40;
    moveCheck();
  }
}
