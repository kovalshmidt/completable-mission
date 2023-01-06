package com.mission.impossible.objects;

public class Spy {

  public static Spy ETHAN = new Spy("Ethan Hunt");
  public static Spy WILL = new Spy("William Brandt");
  public static Spy ILSA = new Spy("Ilsa Faust");

  private final String name;

  private Spy(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String handleLoot(final Loot loot) {
    switch (loot) {
      case NICE:
        return name + " [When getting the loot '" + loot.getMsg() + "'] : Mission Accomplished!!";
      case BAD:
        return name + " [When getting the loot '" + loot.getMsg() + "'] : That's the wrong door!";
      case VERY_BAD:
        return name + " [When getting the loot '" + loot.getMsg() + "'] : That's a trap!!";
      case UNEXPECTED:
        return name + " [When getting the loot '" + loot.getMsg() + "'] : We cannot open this box!!";
    }
    throw new IllegalArgumentException("Unexpected Loot: " + loot);
  }
}
