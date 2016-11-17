package com.liangyumingblog.memory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MemMonitorExecutor implements Executor {
    public void execute() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new MemMonitor(), 1L, 1L, TimeUnit.SECONDS);
        Util.B();
    }
}
