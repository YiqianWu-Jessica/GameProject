package uoft.csc207.thisisagame.game2;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Timer;

import uoft.csc207.thisisagame.game2.game2units.Boat;
import uoft.csc207.thisisagame.game2.game2units.Box;
import uoft.csc207.thisisagame.game2.game2units.Items;
import uoft.csc207.thisisagame.game2.game2units.Fish;
import uoft.csc207.thisisagame.game2.game2units.Jelly;
import uoft.csc207.thisisagame.game2.game2units.Shark;
import uoft.csc207.thisisagame.game2.game2units.Starfish;

// a class to store data in the game 2
class Game2Data {
  private Timer timer;
  private Handler handler;
  private int boatSize;
  private int fishSize;
  private int sharkSize;
  private int jellySize;
  private int boxSize;
  private int starFishSize;
  private int frameWidth;
  private int frameHeight;
  private int screenWidth;
  private ArrayList<Items> items;
  private Boat boat;
  private int boatX;
  private int boatY;
  Boolean win;
  Boolean lose;
  Boolean gaming;

  Game2Data() {
    handler = new Handler();
    items = new ArrayList<>();
    this.win = false;
    this.lose = false;
    this.gaming = false;
  }

  void addFish() {
    items.add(new Fish(0, 0, frameHeight, screenWidth, fishSize));
  }

  void addShark() {
    items.add(new Shark(0, 0, frameHeight, screenWidth, sharkSize));
  }

  void addStarfish() {
    items.add(new Starfish(0, 0, frameHeight, screenWidth, starFishSize));
  }

  void addJelly() {
    items.add(new Jelly(0, 0, frameHeight, screenWidth, jellySize));
  }

  void addBox() {
    items.add(new Box(8000, 8000, frameHeight, screenWidth, boxSize));
  }

  void setBoat() {
    boat = new Boat(boatX, boatY, frameHeight, frameWidth, screenWidth, boatSize);
  }

  // setters
  void setTimer(Timer timer) {
    this.timer = timer;
  }

  void setBoatSize(int boatSize) {
    this.boatSize = boatSize;
  }

  void setBoxSize(int boxSize) {
    this.boxSize = boxSize;
  }

  void setFishSize(int fishSize) {
    this.fishSize = fishSize;
  }

  void setSharkSize(int sharkSize) {
    this.sharkSize = sharkSize;
  }

  void setJellySize(int jellySize) {
    this.jellySize = jellySize;
  }

  void setStarFishSize(int starFishSize) {
    this.starFishSize = starFishSize;
  }

  void setFrameWidth(int frameWidth) {
    this.frameWidth = frameWidth;
  }

  void setFrameHeight(int frameHeight) {
    this.frameHeight = frameHeight;
  }

  void setScreenWidth(int screenWidth) {
    this.screenWidth = screenWidth;
  }

  void setBoatX(int boatX) {
    this.boatX = boatX;
  }

  void setBoatY(int boatY) {
    this.boatY = boatY;
  }

  ArrayList<Items> getItems() {
    return items;
  }

  Boat getBoat() {
    return boat;
  }

  Timer getTimer() {
    return timer;
  }

  Handler getHandler() {
    return handler;
  }
}
