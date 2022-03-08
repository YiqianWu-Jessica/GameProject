package uoft.csc207.thisisagame.game1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

public class StartLevel1Activity extends Game {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_level1);
  }

  public void startGame(View view) {
    Intent intent = new Intent(getApplicationContext(), Game1Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }
}
