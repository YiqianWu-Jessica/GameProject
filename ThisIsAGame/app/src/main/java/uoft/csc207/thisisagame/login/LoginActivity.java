package uoft.csc207.thisisagame.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import uoft.csc207.thisisagame.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

  private EditText inputUsername;
  private EditText inputPassword;
  private LoginPresenter presenter;
  private String username;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    inputUsername = findViewById(R.id.username);
    inputPassword = findViewById(R.id.password);
    presenter = new LoginPresenter(this, getApplicationContext());
  }

  public void setUsername(String username) {
    this.username = username;
  }

  // click signIn button
  public void signIn(View view) {
    presenter.signIn(inputUsername.getText().toString(), inputPassword.getText().toString());
  }
  // click create account button
  public void createAccount(View view) {
    presenter.createAccount(inputUsername.getText().toString(), inputPassword.getText().toString());
  }

  // proceed to select player
  @Override
  public void navigateToPlayerSelect() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.LoginActivity.this,
            "Login Successful",
            Toast.LENGTH_SHORT)
        .show();
    Intent intent = new Intent(this, PlayerSelectActivity.class);
    intent.putExtra("Username", username);
    startActivity(intent);
    finish();
  }

  // error for login
  @Override
  public void setLoginError() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.LoginActivity.this,
            "Username/Password incorrect",
            Toast.LENGTH_SHORT)
        .show();
  }

  // error for creating account
  public void setUsernameExisted() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.LoginActivity.this,
            "Username already existed",
            Toast.LENGTH_SHORT)
        .show();
  }

  // empty input error for creating account
  public void setInputEmpty() {
    Toast.makeText(
            uoft.csc207.thisisagame.login.LoginActivity.this,
            "Username or password is empty",
            Toast.LENGTH_SHORT)
        .show();
  }
}
