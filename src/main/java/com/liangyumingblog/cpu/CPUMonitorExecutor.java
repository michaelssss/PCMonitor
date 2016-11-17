package com.liangyumingblog.cpu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lWX364284 on 2016/11/16.
 */
public class CPUMonitorExecutor implements Executor {

    @Override
    public void execute() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new CPUMonitor());
        Util.A();
    }
}

