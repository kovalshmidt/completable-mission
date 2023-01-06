
## The Task
In `CompletableFutureOpenSafeLock.class`, implement method `openSafeLock` by writing a CompletableFuture chain 
that invokes following Action methods to get a Loot object.
 - unlockTheDoor
 - figureOutSafetyBoxNumber(victim)
 - hackSecretPin(victim)
 - openSafeLock(boxNumber, pinCode)

 In case an exception occurs, log the error and return Loot.UNEXPECTED
 At the end log the result with:
  `log.info("{} gets the content of the safety box: '{}'", spy.getName(), spy.handleLoot(loot))`

Return the result of CompletableFuture chain by calling .join() at the end

## Test
You can test and compare your implementation by running the `main` method in `App.class`.
To check that the exception is handled in a proper way, uncomment line 44 in Actions and comment line 45,
afterwards run the application and check that the loot returned is Loot.UNEXPECTED.
