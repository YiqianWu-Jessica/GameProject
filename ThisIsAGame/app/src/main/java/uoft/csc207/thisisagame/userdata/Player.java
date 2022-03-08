package uoft.csc207.thisisagame.userdata;

import java.io.Serializable;

public class Player implements Serializable {

  /** A player has the following player info */
  private String playername;

  private int score, level, HP, bonus;

  public Player(String playername) {
    this.playername = playername;
    score = 0;
    level = 1;
    HP = 3;
    bonus = 0;
  }

  public String getPlayername() {
    return playername;
  }

  // setters
  public void setScore(int score) {
    this.score = score;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setHP(int hp) {
    this.HP = hp;
  }

  public void setBonus(int bonus) {
    this.bonus = bonus;
  }

  // getters
  public int getScore() {
    return score;
  }

  public int getLevel() {
    return level;
  }

  public int getHP() {
    return HP;
  }

  public int getBonus() {
    return bonus;
  }

  // player status check
  public Boolean isDead() {
    return HP <= 0;
  }

  // player status reset after lose
  public void reset() {
    score = 0;
    level = 1;
    HP = 3;
    bonus = 0;
  }
}
