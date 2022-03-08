package uoft.csc207.thisisagame.game3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

public class StartLevel3Activity extends Game {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_level3);
  }

  // connect the Game3Activity class with view and playerManager
  public void startGame(View view) {
    Intent intent = new Intent(getApplicationContext(), Game3Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }
}
