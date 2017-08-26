package jp.co.tdc.epbu.tjkun.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TJScheduler {

    private List<ScheduledFuture<?>> futureList;

    private TJScheduler() {

        scheduler = Executors.newScheduledThreadPool(3);
        futureList = new ArrayList<ScheduledFuture<?>>();
    }

    private static TJScheduler instance;

    private ScheduledExecutorService scheduler;

    public static TJScheduler getInstance() {

        if (instance == null) {
            instance = new TJScheduler();
        }

        return instance;
    }

    public void addFuture(Runnable command, long initialDelay, long period, TimeUnit unit) {

        futureList.add(scheduler.scheduleAtFixedRate(command, initialDelay, period, unit));

    }

    public void close() {

        for (ScheduledFuture<?> future : futureList) {

            if (future != null) {
                future.cancel(true);
            }
        }

        scheduler.shutdownNow();
    }

}
