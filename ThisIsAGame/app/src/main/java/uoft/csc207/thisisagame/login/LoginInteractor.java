package uoft.csc207.thisisagame.login;

import android.content.Context;

import uoft.csc207.thisisagame.userdata.AccountManager;

class LoginInteractor {

  private AccountManager accountManager;

  private LoginPresenter presenter;

  // set login
  LoginInteractor(LoginPresenter loginPresenter, Context context) {
    accountManager = new AccountManager(context);
    this.presenter = loginPresenter;
  }

  // set sign in
  void signIn(final String username, final String password) {
    if (accountManager.findAccount(username, password) == null) {
      // credential failed
      presenter.onLoginError();
    } else {
      // login successful
      presenter.setUsername(username);
      presenter.onSuccess();
    }
  }

  // after put username and password then create an account
  void createAccount(String username, String password) {
    if (accountManager.findAccount(username) != null) {
      // the given account name is already taken
      presenter.onRegisterError();
    } else if (username.isEmpty() || password.isEmpty()) {
      // the given account name or password is empty
      presenter.onInputEmpty();
    } else {
      // name and password valid, create the account
      accountManager.addAccount(username, password);
      presenter.setUsername(username);
      presenter.onSuccess();
    }
  }
}
