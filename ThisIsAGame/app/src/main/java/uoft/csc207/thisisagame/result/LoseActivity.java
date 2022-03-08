package uoft.csc207.thisisagame.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;
import uoft.csc207.thisisagame.game1.StartLevel1Activity;
import uoft.csc207.thisisagame.userdata.Player;

public class LoseActivity extends Game {

  Player player;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lose);

    TextView scoreLabel = findViewById(R.id.scoreLabel);
    player = playerManager.getCurrentPlayer();
    scoreLabel.setText("Score: " + player.getScore());
  }

  // replay start at game 1 when lose the game
  public void tryAgain(View view) {
    Intent intent = new Intent(getApplicationContext(), StartLevel1Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }
}
