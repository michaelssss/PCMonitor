package com.liangyumingblog.cpu;

import com.liangyumingblog.cpu.Monitor.WindowsCPUMonitor;
import com.liangyumingblog.logger.Logger;
import com.liangyumingblog.logger.LoggerImpl;

class CPUMonitor implements Runnable {
    private final Logger logger = LoggerImpl.getInstance();
    private com.liangyumingblog.cpu.Monitor.CPUMonitor monitor;

    CPUMonitor() {
        monitor = new WindowsCPUMonitor();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        CPUInfo cpuInfo = new CPUInfo(monitor.getCoreNum(), monitor.getCPUName());
        logger.log(cpuInfo.toString());
    }
}
