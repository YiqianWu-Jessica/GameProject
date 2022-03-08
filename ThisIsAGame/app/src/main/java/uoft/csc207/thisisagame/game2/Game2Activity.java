package uoft.csc207.thisisagame.game2;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import uoft.csc207.thisisagame.SoundEffect;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

public class Game2Activity extends Game implements Game2View {

  private Game2Presenter presenter;
  private Game2Data data;

  private TextView scoreLabel;
  private TextView hpLabel;
  private TextView startLabel;
  private TextView bonusLabel;
  private Button pauseButton;

  private ImageView boat;
  private ImageView shark;
  private ImageView fish;
  private ImageView box;
  private ImageView jelly;
  private ImageView starfish;
  private SoundEffect sound;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2);

    scoreLabel = findViewById(R.id.scoreLabel);
    startLabel = findViewById(R.id.startLabel);
    hpLabel = findViewById(R.id.hpLabel);
    bonusLabel = findViewById(R.id.bonusLabel);
    pauseButton = findViewById(R.id.pause);

    boat = findViewById(R.id.boat);
    shark = findViewById(R.id.shark);
    fish = findViewById(R.id.fish);
    jelly = findViewById(R.id.jelly);
    starfish = findViewById(R.id.starfish);
    box = findViewById(R.id.treabox);

    shark.setX(-80000);
    shark.setY(-80000);
    starfish.setX(-8000);
    starfish.setY(-8000);
    fish.setX(-8000);
    fish.setY(-8000);
    jelly.setX(-80000);
    jelly.setY(-90000);
    box.setX(-900000);
    box.setY(-999999);

    data = new Game2Data();
    presenter = new Game2Presenter(this, playerManager, data);
    sound = new SoundEffect(this);
  }

  // set frame size, boat's position and creature's position after click start
  public void clickStart(View view) {
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int screenWidth = size.x;
    FrameLayout frame = getWindow().findViewById(R.id.frameTop);

    data.setFrameHeight(frame.getHeight());
    data.setFrameWidth(frame.getWidth());
    data.setScreenWidth(screenWidth);
    data.setBoatSize(boat.getHeight());
    data.setFishSize(fish.getWidth());
    data.setSharkSize(shark.getWidth());
    data.setJellySize(jelly.getWidth());
    data.setStarFishSize(starfish.getWidth());
    data.setBoxSize(box.getWidth());
    data.setBoatX((int) boat.getX());
    data.setBoatY((int) boat.getY());
    startLabel.setClickable(false);
    startLabel.setText("");
    presenter.clickStart();
  }

  // set score HP bonus label
  @Override
  public void setScoreLabel(int score) {
    String scoreMessage = "Score: " + score;
    scoreLabel.setText(scoreMessage);
  }

  @Override
  public void setHPLabel(int hp) {
    String hpMessage = "HP: " + hp;
    hpLabel.setText(hpMessage);
  }

  @Override
  public void setBonusLabel(int bonus) {
    String bonusMessage = "Bonus: " + bonus;
    bonusLabel.setText(bonusMessage);
  }

  // set button stop
  @Override
  public void setPause() {
    pauseButton.setText("Pause");
  }

  @Override
  public void setResume() {
    pauseButton.setText("Resume");
  }

  // set creatures' position
  @Override
  public void setFishPos(int x, int y) {
    fish.setX(x);
    fish.setY(y);
  }

  @Override
  public void setJellyPos(int x, int y) {
    jelly.setX(x);
    jelly.setY(y);
  }

  @Override
  public void setSharkPos(int x, int y) {
    shark.setX(x);
    shark.setY(y);
  }

  @Override
  public void setStarFishPos(int x, int y) {
    starfish.setX(x);
    starfish.setY(y);
  }

  @Override
  public void setBoxPos(int x, int y) {
    box.setX(x);
    box.setY(y);
  }

  @Override
  public void setBoatPos(float x, float y) {
    boat.setX(x);
    boat.setY(y);
  }

  @Override
  public void playLoseSound() {
    sound.playLoseHp();
  }

  @Override
  public void playWinSound() {
    sound.playWin();
  }

  @Override
  public void playGetSound() {
    sound.playGetHp();
  }

  // buttons
  public void clickLeft(View view) {
    presenter.clickLeft();
  }

  public void clickRight(View view) {
    presenter.clickRight();
  }

  public void clickUp(View view) {
    presenter.clickUp();
  }

  public void clickDown(View view) {
    presenter.clickDown();
  }

  public void clickPause(View view) {
    presenter.clickPause();
  }
}
