package uoft.csc207.thisisagame.game1;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import uoft.csc207.thisisagame.SoundEffect;

public class Game1Activity extends Game implements Game1View {
  EditText inputWord;
  private Game1Presenter game1Presenter;
  private TextView scoreLabel;
  private TextView hpLabel;
  private TextView bonusLabel;
  private ImageView jellyFish;
  private ImageView turtle;
  private ImageView bomb;
  private ImageView why;
  private ImageView fish;
  private SoundEffect sound;
  private TextView question;

  protected void onCreate(Bundle savedInstanceState) {
    // define gamePresenter which can got information from playerManager
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game1);

    scoreLabel = findViewById(R.id.scoreLabel1);
    hpLabel = findViewById(R.id.hpLabel1);
    bonusLabel = findViewById(R.id.bonusLabel1);
    question = findViewById(R.id.question);

    game1Presenter = new Game1Presenter(this, playerManager);

    jellyFish = findViewById(R.id.g1Jelly);
    turtle = findViewById(R.id.g1Turtle);
    bomb = findViewById(R.id.g1Bomb);
    why = findViewById(R.id.g1QuestionMark);
    fish = findViewById(R.id.g1Fish);
    turtle.setImageAlpha(0);
    jellyFish.setImageAlpha(0);
    bomb.setImageAlpha(0);
    why.setImageAlpha(0);

    sound = new SoundEffect(this);
  }

  public void checkAnswer(View view) {
    inputWord = findViewById(R.id.answer);
    String answer = inputWord.getText().toString();
    inputWord.setText("");
    game1Presenter.getCheckAnswer(answer);
  }

  // set to the second question
  public void toSecondQuestion() {
    fish.setImageAlpha(0);
    turtle.setImageAlpha(255);
  }

  // set to the third question
  public void toThirdQuestion() {
    turtle.setImageAlpha(0);
    bomb.setImageAlpha(255);
  }

  // set to the fourth question
  public void toFourthQuestion() {
    bomb.setImageAlpha(0);
    jellyFish.setImageAlpha(255);
  }

  // set to the fifth question
  public void toFifthQuestion() {
    String questionFive = "Which letter is a question?";
    question.setText(questionFive);
    jellyFish.setImageAlpha(0);
    why.setImageAlpha(255);
  }

  // set hp value of the player
  @Override
  public void setHP(String hp) {
    String hpMessage = "HP: " + hp;
    Toast.makeText(getApplicationContext(), hpMessage, Toast.LENGTH_SHORT).show();
    hpLabel.setText(hpMessage);
  }

  // set bonus mark of the player
  @Override
  public void setBonus(String bonus) {
    String bonusMessage = "Bonus: " + bonus;
    bonusLabel.setText(bonusMessage);
  }

  // set score of the player
  @Override
  public void setScore(String score) {
    String scoreMessage = "Score: " + score;
    scoreLabel.setText(scoreMessage);
  }

  // when the player plays wrong then show him he did wrong
  @Override
  public void wrong() {
    Toast.makeText(getApplicationContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
    sound.playLoseHp();
  }

  // chen the player give the correct answer then show him he did correct
  @Override
  public void correct() {
    Toast.makeText(getApplicationContext(), "correct answer", Toast.LENGTH_SHORT).show();
    sound.playWin();
  }
}
