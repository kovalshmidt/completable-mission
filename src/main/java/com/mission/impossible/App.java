package com.mission.impossible;

import com.mission.impossible.comparison.CompletableFutureOpenSafeLock;
import com.mission.impossible.comparison.FutureOpenSafeLock;
import com.mission.impossible.comparison.SingleThreadOpenSafeLock;
import com.mission.impossible.objects.Actions;
import com.mission.impossible.objects.Spy;
import com.mission.impossible.objects.Loot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws Exception {

    log.info("\n\n SINGLE THREAD ====");
    long startSingleThread = System.currentTimeMillis();
    final Loot singleThreadLoot = new SingleThreadOpenSafeLock().openSafeLockFunctional(Spy.ILSA, "Mr. Salomon Lane");
    long endSingleThread = System.currentTimeMillis();
    log.info("SINGLE THREAD executed in {} ms", endSingleThread - startSingleThread);

    log.info("\n\n PLAIN FUTURES ====");
    long startFutureThread = System.currentTimeMillis();
    final Loot plainFutureLoot = new FutureOpenSafeLock().openSafeLock(Spy.WILL, "Mr. August Walker");
    long endFutureThread = System.currentTimeMillis();
    log.info("PLAIN FUTURES executed in {} ms", endFutureThread - startFutureThread);

    log.info("\n\n COMPLETABLE FUTURE ====");
    long startCompletableFutureThread = System.currentTimeMillis();
    final Loot completableFutureLoot = new CompletableFutureOpenSafeLock(new Actions()).openSafeLock(Spy.ETHAN, "Mr. Jim Phelps");
    long endCompletableFutureThread = System.currentTimeMillis();
    log.info("COMPLETABLE FUTURE executed in {} ms", endCompletableFutureThread - startCompletableFutureThread);

  }
}
