package uoft.csc207.thisisagame.login;

interface LoginView {

  void setUsername(String username);

  void setLoginError();

  void setUsernameExisted();

  void setInputEmpty();

  void navigateToPlayerSelect();
}
