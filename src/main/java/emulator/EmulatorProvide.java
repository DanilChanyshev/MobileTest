package emulator;

import jakarta.inject.Singleton;
import lombok.SneakyThrows;
import java.util.Collections;
import java.util.concurrent.*;

@Singleton
public class EmulatorProvide {

  private final BlockingQueue<Emulator> emulators;

  {
    emulators = new ArrayBlockingQueue<>(Emulator.values().length);
    Collections.addAll(emulators, Emulator.values());
  }

  private final ThreadLocal<Emulator> currentEmulator = new ThreadLocal<>();

  @SneakyThrows
  public Emulator takeAndGet() {
    Emulator emulator = emulators.poll(2, TimeUnit.MINUTES);
    currentEmulator.set(emulator);
    return emulator;
  }

  public Emulator get() {
    return currentEmulator.get();
  }

  @SneakyThrows
  @SuppressWarnings("ResultOfMethodCallIgnored")
  public void putBack() {
    emulators.offer(get(), 2, TimeUnit.MINUTES);
  }
}
