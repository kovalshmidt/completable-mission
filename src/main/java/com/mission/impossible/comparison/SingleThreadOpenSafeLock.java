package com.mission.impossible.comparison;

import com.mission.impossible.objects.Actions;
import com.mission.impossible.objects.Loot;
import com.mission.impossible.objects.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class SingleThreadOpenSafeLock {

  private static final Logger log = LoggerFactory.getLogger(SingleThreadOpenSafeLock.class);
  private Actions actions;

  public SingleThreadOpenSafeLock() {
    this.actions = new Actions();
  }

  public Loot openSafeLock(final Spy spy, final String victim) {
    actions.unlockTheDoor();

    final String safetyBoxNumber = actions.figureOutSafetyBoxNumber(victim);
    final int pin = actions.hackSecretPin(victim);

    final Loot loot = actions.openSafeLock(safetyBoxNumber, pin);
    log.info("{} gets the content of the safety box: '{}'", spy.getName(), spy.handleLoot(loot));
    return loot;
  }

  public Loot openSafeLockFunctional(final Spy spy, final String victim) {
    return Stream.of(actions.unlockTheDoor()) // Unlock the door
      .map((ignore) -> actions.figureOutSafetyBoxNumber(victim)) // Get Safety Box Number
      .map((safetyBoxNumber) -> actions.openSafeLock(safetyBoxNumber, actions.hackSecretPin(victim)))  // Get the pin code to the safety box and Use the pin code to open the safe box and get the loot
      .peek((loot -> log.info("{} gets the content of the safety box: '{}'", spy.getName(), spy.handleLoot(loot)))) // Print the result
      .findFirst().get();
  }
}
