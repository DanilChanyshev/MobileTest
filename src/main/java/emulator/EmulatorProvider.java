package emulator;

import jakarta.inject.Singleton;
import lombok.SneakyThrows;
import java.util.Arrays;
import java.util.concurrent.*;

@Singleton
public class EmulatorProvider {

  private final BlockingQueue<Emulator> emulators  = new ArrayBlockingQueue<>(Emulator.values().length, false, Arrays.asList(Emulator.values()));
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
