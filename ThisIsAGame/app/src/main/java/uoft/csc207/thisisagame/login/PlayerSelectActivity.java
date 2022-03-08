package uoft.csc207.thisisagame.login;

import androidx.appcompat.app.AppCompatActivity;
import uoft.csc207.thisisagame.R;
import uoft.csc207.thisisagame.game1.StartLevel1Activity;
import uoft.csc207.thisisagame.game2.StartLevel2Activity;
import uoft.csc207.thisisagame.game3.StartLevel3Activity;
import uoft.csc207.thisisagame.score.ScoreBoardActivity;
import uoft.csc207.thisisagame.userdata.PlayerManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class PlayerSelectActivity extends AppCompatActivity implements PlayerSelectView {

  private EditText inputPlayerName;
  private TextView player1View, player2View, player3View, selectedPlayerView;
  private PlayerSelectPresenter presenter;
  private PlayerManager playerManager;
  private String username;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player_select);

    username = getIntent().getStringExtra("Username");

    inputPlayerName = findViewById(R.id.playername);
    player1View = findViewById(R.id.player1);
    player2View = findViewById(R.id.player2);
    player3View = findViewById(R.id.player3);
    selectedPlayerView = findViewById(R.id.selectedplayer);
    selectedPlayerView.setText("");
    presenter = new PlayerSelectPresenter(this, username, getApplicationContext());
  }

  @Override
  public void setPlayerManager(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  @Override
  public void setPlayer1(String player1Name) {
    player1View.setText(player1Name);
  }

  @Override
  public void setPlayer2(String player2Name) {
    player2View.setText(player2Name);
  }

  @Override
  public void setPlayer3(String player3Name) {
    player3View.setText(player3Name);
  }

  // click methods
  // select the first player
  public void pickPlayer1(View view) {
    selectedPlayerView.setText(player1View.getText().toString());
  }

  // select the second player
  public void pickPlayer2(View view) {
    selectedPlayerView.setText(player2View.getText().toString());
  }

  // select the third player
  public void pickPlayer3(View view) {
    selectedPlayerView.setText(player3View.getText().toString());
  }

  public void removePlayer1(View view) {
    try {
      player1View.setText("");
      presenter.removePlayer1();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void removePlayer2(View view) {
    try {
      player2View.setText("");
      presenter.removePlayer2();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void removePlayer3(View view) {
    try {
      player3View.setText("");
      presenter.removePlayer3();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // select the player you just typed in
  public void selectPlayer(View view) {
    selectedPlayerView.setText(inputPlayerName.getText().toString());
  }

  public void startGame(View view) {
    presenter.startGame(selectedPlayerView.getText().toString());
  }

  // errors
  @Override
  public void setEmptyPlayerNameError() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "No player selected",
            Toast.LENGTH_SHORT)
        .show();
  }

  // more than three players is not allowed
  @Override
  public void setTooManyPlayersError() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "Please remove one previous player and try again",
            Toast.LENGTH_SHORT)
        .show();
  }

  // navigations
  @Override
  public void navigateToGame1() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "Start Game1",
            Toast.LENGTH_SHORT)
        .show();
    Intent intent = new Intent(this, StartLevel1Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  @Override
  public void navigateToGame2() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "Start Game2",
            Toast.LENGTH_SHORT)
        .show();
    Intent intent = new Intent(this, StartLevel2Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  @Override
  public void navigateToGame3() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "Start Game3",
            Toast.LENGTH_SHORT)
        .show();
    Intent intent = new Intent(this, StartLevel3Activity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }

  @Override
  public void navigateToScoreBoard() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.PlayerSelectActivity.this,
            "You have finished all games!",
            Toast.LENGTH_SHORT)
        .show();
    Intent intent = new Intent(this, ScoreBoardActivity.class);
    intent.putExtra("PlayerManager", playerManager);
    startActivity(intent);
    finish();
  }
}
