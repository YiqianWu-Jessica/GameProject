package uoft.csc207.thisisagame.game3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

import uoft.csc207.thisisagame.SoundEffect;

public class Game3Activity extends Game implements Game3View {

  private Game3Presenter game3Presenter;

  private TextView scoreLabel;
  private TextView hpLabel;
  private TextView bonusLabel;

  private ImageView image;

  private SoundEffect sound;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game3);

    // define scoreLabel,bonusLabel,hpLabel
    scoreLabel = (TextView) findViewById(R.id.scoreLabel);
    bonusLabel = (TextView) findViewById(R.id.bonusLabel);
    hpLabel = (TextView) findViewById(R.id.hpLabel);

    // define gamePresenter which can got information from playerManager
    game3Presenter = new Game3Presenter(this, playerManager);

    // define image
    image = findViewById(R.id.image);

    /* define sound */
    sound = new SoundEffect(this);

    // define answer button
    Button answerBtn1,
        answerBtn2,
        answerBtn3,
        answerBtn4,
        answerBtn5,
        answerBtn6,
        answerBtn7,
        answerBtn8,
        answerBtn9;

    answerBtn1 = findViewById(R.id.answerBtn1);
    answerBtn2 = findViewById(R.id.answerBtn2);
    answerBtn3 = findViewById(R.id.answerBtn3);
    answerBtn4 = findViewById(R.id.answerBtn4);
    answerBtn5 = findViewById(R.id.answerBtn5);
    answerBtn6 = findViewById(R.id.answerBtn6);
    answerBtn7 = findViewById(R.id.answerBtn7);
    answerBtn8 = findViewById(R.id.answerBtn8);
    answerBtn9 = findViewById(R.id.answerBtn9);

    answerBtn1.setText("0");
    answerBtn2.setText("1");
    answerBtn3.setText("2");
    answerBtn4.setText("3");
    answerBtn5.setText("4");
    answerBtn6.setText("5");
    answerBtn7.setText("6");
    answerBtn8.setText("7");
    answerBtn9.setText("8");
  }

  // set hp message in the game
  @Override
  public void setHp(int hp) {
    String hpMessage = "HP: " + hp;
    hpLabel.setText(hpMessage);
  }

  // set bonus message in the game
  @Override
  public void setBonus(int bonus) {
    String bonusMessage = "Bonus: " + bonus;
    bonusLabel.setText(bonusMessage);
  }

  // set score message in the game
  @Override
  public void setScore(int score) {
    String scoreMessage = "Score: " + score;
    scoreLabel.setText(scoreMessage);
  }

  // show picture and remind word when click diamond
  @Override
  public void clickDiamond() {
    image.setImageResource(R.drawable.diamond);
    Toast.makeText(getApplicationContext(), "A diamond! You win!", Toast.LENGTH_SHORT).show();
    sound.playWin();
  }

  // show picture and remind word when click bomb
  @Override
  public void clickBomb() {
    image.setImageResource(R.drawable.bomb);
    Toast.makeText(getApplicationContext(), "A bomb! Lose one life!", Toast.LENGTH_SHORT).show();
    sound.playLoseHp();
  }

  // show picture and remind word when click crown
  @Override
  public void clickCrown() {
    image.setImageResource(R.drawable.crown);
    Toast.makeText(getApplicationContext(), "A crown! Bonus!", Toast.LENGTH_SHORT).show();
    sound.playGetHp();
  }

  // show picture and remind word when click ring
  @Override
  public void clickRing() {
    image.setImageResource(R.drawable.ring);
    Toast.makeText(getApplicationContext(), "A ring! Get one life!", Toast.LENGTH_SHORT);
    sound.playGetHp();
  }

  public void check(View view) {
    Button answerBtn = findViewById(view.getId());
    String btnValue = answerBtn.getText().toString();
    int key = Integer.parseInt(btnValue);
    game3Presenter.checkValue(key);
    answerBtn.setEnabled(false);
  }
}
