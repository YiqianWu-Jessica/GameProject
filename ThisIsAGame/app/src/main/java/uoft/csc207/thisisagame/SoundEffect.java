package uoft.csc207.thisisagame;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundEffect {

  private static SoundPool soundPool;
  private static int winSound;
  private static int looseHpSound;
  private static int getHpSound;

  // set sounds
  public SoundEffect(Context context) {
    soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    winSound = soundPool.load(context, R.raw.win, 1);
    getHpSound = soundPool.load(context, R.raw.get, 1);
    looseHpSound = soundPool.load(context, R.raw.lose, 1);
  }

  // play under a losing condition
  public void playLoseHp() {
    soundPool.play(looseHpSound, 1.0f, 1.0f, 1, 0, 1.0f);
  }

  // play when get bonus or hp
  public void playGetHp() {
    soundPool.play(getHpSound, 1.0f, 1.0f, 1, 0, 1.0f);
  }

  // play under a winning condition
  public void playWin() {
    soundPool.play(winSound, 1.0f, 1.0f, 1, 0, 1.0f);
  }
}
