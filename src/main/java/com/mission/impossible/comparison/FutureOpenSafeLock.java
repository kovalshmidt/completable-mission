package com.mission.impossible.comparison;

import com.mission.impossible.objects.Actions;
import com.mission.impossible.objects.Spy;
import com.mission.impossible.objects.Loot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureOpenSafeLock {
  private static final Logger log = LoggerFactory.getLogger(FutureOpenSafeLock.class);
  private Actions actions;

  public FutureOpenSafeLock() {
    this.actions = new Actions();
  }

  public Loot openSafeLock(final Spy spy, final String victim) throws Exception {

    final ExecutorService executorService = Executors.newFixedThreadPool(4);

    // Unlock the door
    final Future<Boolean> doorUnlockFuture = executorService.submit(
      actions::unlockTheDoor
    );
    doorUnlockFuture.get();

    // Get Safety Box Number
    final Future<String> safetyBoxNumberFuture = executorService.submit(
      () -> actions.figureOutSafetyBoxNumber(victim)
    );

    // Get the pin code to the safety box
    final Future<Integer> pinRetrieverFuture = executorService.submit(
      () -> actions.hackSecretPin(victim)
    );

    // Use the pin code to open the safe box and get the loot
    final Future<Loot> lootFuture = executorService.submit(
      () -> actions.openSafeLock(safetyBoxNumberFuture.get(), pinRetrieverFuture.get())
    );

    executorService.shutdown();
    final Loot loot = lootFuture.get();
    log.info("{} gets the content of the safety box: '{}'", spy.getName(), spy.handleLoot(loot));

    return loot;
  }
}
