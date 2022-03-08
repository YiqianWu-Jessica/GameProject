package uoft.csc207.thisisagame.userdata;

// store username and password only
class Account {

  private String username, password;

  Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // check if the username and password match the account
  Boolean checkCredentials(String username, String password) {
    return username.equals(this.username) && password.equals(this.password);
  }

  String getName() {
    return username;
  }

  String getPassword() {
    return password;
  }
}
