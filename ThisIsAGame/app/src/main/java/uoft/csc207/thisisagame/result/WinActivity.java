package uoft.csc207.thisisagame.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.game1.StartLevel1Activity;
import uoft.csc207.thisisagame.game2.StartLevel2Activity;
import uoft.csc207.thisisagame.game3.StartLevel3Activity;
import uoft.csc207.thisisagame.R;

public class WinActivity extends Game implements WinView {

  private WinPresenter presenter;
  private TextView scoreLabel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_win);

    scoreLabel = findViewById(R.id.scoreLabel);
    presenter = new WinPresenter(this, playerManager);
  }

  // set player to next level
  public void buttonToNext(View view) {
    presenter.buttonToNext();
  }

  // display current score
  @Override
  public void setScoreLabel(int score) {
    String scoreMessage = Integer.toString(score);
    scoreLabel.setText(scoreMessage);
  }

  @Override
  public void navigateToGame1() {
    Toast.makeText(WinActivity.this, "Start Game1", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, StartLevel1Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  @Override
  public void navigateToGame2() {
    Toast.makeText(WinActivity.this, "Start Game2", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, StartLevel2Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  @Override
  public void navigateToGame3() {
    Toast.makeText(WinActivity.this, "Start Game3", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, StartLevel3Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  // intent to score board page
  public void navigateToBoard() {
    Toast.makeText(WinActivity.this, "Start ScoreBoard", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, uoft.csc207.thisisagame.score.ScoreBoardActivity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }
}
