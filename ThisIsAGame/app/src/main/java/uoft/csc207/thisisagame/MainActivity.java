package uoft.csc207.thisisagame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import uoft.csc207.thisisagame.login.LoginActivity;

/** A main class which used to start the whole game */
public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  // proceed to login
  public void startLogin(View view) {
    startActivity(new Intent(this, LoginActivity.class));
  }
}
