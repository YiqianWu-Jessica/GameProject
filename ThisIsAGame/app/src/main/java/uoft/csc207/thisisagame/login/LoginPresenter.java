package uoft.csc207.thisisagame.login;

import android.content.Context;

class LoginPresenter {

  private LoginView loginView;
  private LoginInteractor loginInteractor;
  private String username;

  LoginPresenter(LoginView loginView, Context context) {
    this.loginView = loginView;
    this.loginInteractor = new LoginInteractor(this, context);
  }

  void setUsername(String username) {
    this.username = username;
  }

  void signIn(String username, String password) {
    loginInteractor.signIn(username, password);
  }

  void createAccount(String username, String password) {
    loginInteractor.createAccount(username, password);
  }

  void onLoginError() {
    if (loginView != null) {
      loginView.setLoginError();
    }
  }

  void onRegisterError() {
    if (loginView != null) {
      loginView.setUsernameExisted();
    }
  }

  void onInputEmpty() {
    if (loginView != null) {
      loginView.setInputEmpty();
    }
  }

  // login or register success
  void onSuccess() {
    if (loginView != null) {
      loginView.setUsername(username);
      loginView.navigateToPlayerSelect();
    }
  }
}
