package com.mission.impossible.comparison;

import java.util.concurrent.CompletableFuture;

import com.mission.impossible.objects.Actions;
import com.mission.impossible.objects.Loot;
import com.mission.impossible.objects.Spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompletableFutureOpenSafeLock {

  private static final Logger log = LoggerFactory.getLogger(CompletableFutureOpenSafeLock.class);

  private Actions actions;


  public CompletableFutureOpenSafeLock(Actions actions) {
    this.actions = actions;
  }

  public Loot openSafeLock(final Spy spy, final String victim) {

    //
    return null;
  }
}
