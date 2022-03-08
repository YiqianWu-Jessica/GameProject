package uoft.csc207.thisisagame.score;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import uoft.csc207.thisisagame.Game;
import uoft.csc207.thisisagame.R;
import uoft.csc207.thisisagame.login.LoginActivity;

import android.widget.Toast;
import android.content.Intent;

// display score, hp or bonus ranking by choice
public class ScoreBoardActivity extends Game implements ScoreBoardView {

  private ScoreBoardPresenter presenter;
  private String scoreRank, hpRank, bonusRank;
  private TextView rankView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_score_board);

    rankView = findViewById(R.id.rankview);
    presenter = new ScoreBoardPresenter(this, playerManager, getApplicationContext());
  }

  // save score, hp, bonus strings
  @Override
  public void setRanks(String scoreRank, String hpRank, String bonusRank) {
    this.scoreRank = scoreRank;
    this.hpRank = hpRank;
    this.bonusRank = bonusRank;
  }

  // buttons
  public void displayScoreRank(View view) {
    rankView.setText(scoreRank);
  }

  public void displayHPRank(View view) {
    rankView.setText(hpRank);
  }

  public void displayBonusRank(View view) {
    rankView.setText(bonusRank);
  }

  public void navigateToLogin(View view) {
    Toast.makeText(
            uoft.csc207.thisisagame.score.ScoreBoardActivity.this,
            "Back to login page",
            Toast.LENGTH_SHORT)
        .show();
    startActivity(new Intent(this, LoginActivity.class));
    finish();
  }
}
