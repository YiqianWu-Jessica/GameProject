package uoft.csc207.thisisagame.game2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;

public class StartLevel2Activity extends Game {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_level2);
  }

  public void startGame(View view) {
    Intent intent = new Intent(getApplicationContext(), Game2Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }
}
