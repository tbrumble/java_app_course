package homework4;

import java.time.Clock;

public class TimerStopWatch {
    private static TimerStopWatch INSTANCE = null;
    private static long startTime = 0l;

    public static TimerStopWatch getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TimerStopWatch();
        }
        return INSTANCE;
    }

    public void startTime() {
        startTime = Clock.systemDefaultZone().millis();
    }

    public long stopTime() {
        long result = Clock.systemDefaultZone().millis() - startTime;
        startTime = 0l;
        return result;
    }
}
