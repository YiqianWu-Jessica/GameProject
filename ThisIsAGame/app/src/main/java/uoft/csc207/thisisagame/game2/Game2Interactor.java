package uoft.csc207.thisisagame.game2;

import java.util.Timer;
import java.util.TimerTask;

import uoft.csc207.thisisagame.game2.game2units.Box;
import uoft.csc207.thisisagame.game2.game2units.Items;
import uoft.csc207.thisisagame.game2.game2units.Fish;
import uoft.csc207.thisisagame.game2.game2units.Jelly;
import uoft.csc207.thisisagame.game2.game2units.Shark;
import uoft.csc207.thisisagame.game2.game2units.Starfish;
import uoft.csc207.thisisagame.userdata.Player;
import uoft.csc207.thisisagame.userdata.PlayerManager;

class Game2Interactor {
  private Game2Presenter presenter;
  private Game2Data data;
  private PlayerManager playerManager;
  private Player player;

  Game2Interactor(Game2Presenter presenter, PlayerManager playerManager, Game2Data data) {
    this.presenter = presenter;
    this.playerManager = playerManager;
    this.data = data;
    player = this.playerManager.getCurrentPlayer();
    presenter.setHPLabel(player.getHP());
    presenter.setScoreLabel(player.getScore());
    presenter.setBonusLabel(player.getBonus());
  }

  // add creatures and play
  void clickStart() {
    data.addFish();
    data.addShark();
    data.addStarfish();
    data.addJelly();
    data.addBox();
    data.setBoat();
    data.gaming = true;
    setTimer();
  }

  private void move() {
    for (Items i : data.getItems()) {
      i.move();
    }
  }

  private void checkHit() {
    for (Items i : data.getItems()) {
      if (checkCentre(i.getCentreX(), i.getCentreY())) {
        player.setScore(player.getScore() + i.getScore());
        player.setHP(player.getHP() + i.getHP());
        player.setBonus(player.getBonus() + i.getBonus());
        presenter.setScoreLabel(player.getScore());
        presenter.setHPLabel(player.getHP());
        presenter.setBonusLabel(player.getBonus());
        i.setX(-10000000);
        if (i instanceof Starfish) {
          presenter.playGetSound();
        } else if (i instanceof Box) {
          presenter.playWinSound();
          data.win = true;
        } else if (i instanceof Shark) {
          presenter.playLoseSound();
          if (player.isDead()) {
            data.lose = true;
          }
        }
      }
    }
  }

  private void setTimer() {
    data.setTimer(new Timer());
    data.getTimer()
        .schedule(
            new TimerTask() {
              @Override
              public void run() {
                data.getHandler()
                    .post(
                        new Runnable() {
                          @Override
                          public void run() {
                            if (data.win) {
                              player.setLevel(3);
                              playerManager.saveToFile();
                              presenter.win();
                              data.getTimer().cancel();
                            } else if (data.lose) {
                              player.reset();
                              playerManager.saveToFile();
                              presenter.lose();
                              data.getTimer().cancel();
                            } else {
                              move();
                              checkHit();
                              setPos();
                            }
                          }
                        });
              }
            },
            40,
            40);
  }

  // let the boat turn left
  void clickLeft() {
    if (data.gaming) {
      data.getBoat().moveLeft();
      presenter.setBoatPos(data.getBoat().getX(), data.getBoat().getY());
    }
  }

  // let the boat turn right
  void clickRight() {
    if (data.gaming) {
      data.getBoat().moveRight();
      presenter.setBoatPos(data.getBoat().getX(), data.getBoat().getY());
    }
  }

  // let the boat turn up
  void clickUp() {
    if (data.gaming) {
      data.getBoat().moveUp();
      presenter.setBoatPos(data.getBoat().getX(), data.getBoat().getY());
    }
  }

  // let the boat turn down
  void clickDown() {
    if (data.gaming) {
      data.getBoat().moveDown();
      presenter.setBoatPos(data.getBoat().getX(), data.getBoat().getY());
    }
  }

  // after click pause button,
  // change button text and set gaming to pause or resume
  void clickPause() {
    if (data.gaming) {
      presenter.onResume();
      data.gaming = false;
      data.getTimer().cancel();
    } else {
      presenter.onPause();
      data.gaming = true;
      data.setTimer(new Timer());
      setTimer();
    }
  }

  // check boat center position
  private boolean checkCentre(int x, int y) {
    return (data.getBoat().getX() <= x
        && x <= data.getBoat().getX() + data.getBoat().getBoatSize()
        && data.getBoat().getY() <= y
        && y <= data.getBoat().getY() + data.getBoat().getBoatSize());
  }

  // set all item's position on the screen
  private void setPos() {
    for (Items i : data.getItems()) {
      if (i instanceof Fish) {
        presenter.setFishPos(i.getX(), i.getY());
      } else if (i instanceof Jelly) {
        presenter.setJellyPos(i.getX(), i.getY());
      } else if (i instanceof Shark) {
        presenter.setSharkPos(i.getX(), i.getY());
      } else if (i instanceof Starfish) {
        presenter.setStarFishPos(i.getX(), i.getY());
      } else if (i instanceof Box) {
        presenter.setBoxPos(i.getX(), i.getY());
      }
    }
  }
}
