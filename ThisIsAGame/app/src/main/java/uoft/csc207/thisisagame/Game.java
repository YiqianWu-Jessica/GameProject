package uoft.csc207.thisisagame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import uoft.csc207.thisisagame.userdata.PlayerManager;
import uoft.csc207.thisisagame.result.LoseActivity;
import uoft.csc207.thisisagame.result.WinActivity;

/**
 * An abstract super class for all game activity (To all group mates: for continuity of the game
 * info through the gaming process, pls make all games extends this class, including the menu and
 * result. In the case when an activity does not extends this one, be sure to add according intent)
 */
public abstract class Game extends AppCompatActivity {

  public PlayerManager playerManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /* get the player manager from the previous activity */
    playerManager = (PlayerManager) getIntent().getSerializableExtra("PlayerManager");
  }

  // go to win activity
  public void win() {
    Intent intent = new Intent(this, WinActivity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }

  // go to lose activity
  public void lose() {
    Intent intent = new Intent(this, LoseActivity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
  }
}
