package uoft.csc207.thisisagame.userdata;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/** a PlayerManager store players for a specific user account* */
public class PlayerManager implements Serializable {
  // an account has a "username.txt" file
  // using "player1, score, level, hp, bonus" at each line to store a player
  // each account can have up to 3 players under one account

  private ArrayList<Player> playerList;
  private Player currentPlayer;
  private String filename;

  public PlayerManager(Context context, String username) {
    playerList = new ArrayList<>();
    currentPlayer = null;
    this.filename = context.getFilesDir() + username + ".txt";
    readFromFile();
  }

  // read from the players file and set up a list of Player objects
  private void readFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line = reader.readLine();
      while (line != null) {
        String[] playerInfo = line.split(", ");
        Player player = new Player(playerInfo[0]);
        player.setScore(Integer.parseInt(playerInfo[1]));
        player.setLevel(Integer.parseInt(playerInfo[2]));
        player.setHP(Integer.parseInt(playerInfo[3]));
        player.setBonus(Integer.parseInt(playerInfo[4]));
        playerList.add(player);
        line = reader.readLine();
      }
    } catch (IOException e) {
      // Error occurred opening raw file for reading.
      e.printStackTrace();
    }
  }

  // save all player latest updates to the file
  public void saveToFile() {
    // create a new file and save players info in it
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
      for (Player player : playerList) {
        writer.write(
            player.getPlayername()
                + ", "
                + player.getScore()
                + ", "
                + player.getLevel()
                + ", "
                + player.getHP()
                + ", "
                + player.getBonus());
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Player> getPlayerList() {
    return playerList;
  }

  public int getNumberOfPlayers() {
    return playerList.size();
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  // return whether the players is in the list
  public Boolean playerIsInTheList(String playerName) {
    Boolean playerInTheList = false;
    for (Player player : playerList) {
      if (player.getPlayername().equals(playerName)) {
        playerInTheList = true;
      }
    }
    return playerInTheList;
  }

  // set current player by name
  public void setCurrentPlayer(String playerName) {
    for (Player player : playerList) {
      if (player.getPlayername().equals(playerName)) {
        setCurrentPlayer(player);
      }
    }
  }

  public void setCurrentPlayer(Player player) {
    currentPlayer = player;
  }

  // add a new player to the player list
  public void addPlayer(Player player) {
    playerList.add(player);
    saveToFile();
  }

  // remove one player from the player list
  public void removePlayer(String playerName) {
    for (Player player : playerList) {
      if (player.getPlayername().equals(playerName)) {
        playerList.remove(player);
        saveToFile();
      }
    }
  }
}
