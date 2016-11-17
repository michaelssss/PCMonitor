package com.liangyumingblog.cpu.Monitor;

public interface CPUMonitor {
    int getCoreNum();

    float getUseRate();

    String getCPUName();

}
