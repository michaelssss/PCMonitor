package com.liangyumingblog.memory;

import com.liangyumingblog.logger.Logger;
import com.liangyumingblog.logger.LoggerImpl;
import com.liangyumingblog.memory.Monitor.MemInfo;
import com.liangyumingblog.memory.Monitor.WindowsMemMonitor;

public class MemMonitor implements Runnable {
    private final Logger logger = LoggerImpl.getInstance();
    private MemInfo memInfo;

    public MemMonitor() {
        this.memInfo = new WindowsMemMonitor();
    }

    @Override
    public void run() {
        Memory memory = new Memory(memInfo.getTotal());
        memory.setFree(memInfo.getFree());
        logger.log(memory.toString());
    }
}
