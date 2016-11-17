package com.liangyumingblog;

import com.liangyumingblog.cpu.CPUMonitorExecutor;
import com.liangyumingblog.memory.MemMonitorExecutor;

public class StartUp {
    public static void main(String[] args) {
        Executor CPUMonitor = new CPUMonitorExecutor();
        Executor memoryMonitor = new MemMonitorExecutor();
        CPUMonitor.execute();
        memoryMonitor.execute();
    }
}
