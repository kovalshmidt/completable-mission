package com.mission.impossible.objects;

import java.util.concurrent.ThreadLocalRandom;

public enum Loot {
  NICE("Secret Formula!"),
  BAD("Empty!"),
  VERY_BAD("Red light!"),
  UNEXPECTED("broken");

  private final String msg;

  Loot(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public static Loot randomLoot() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return Loot.values()[ThreadLocalRandom.current().nextInt(0, 3)];
  }
}
