package com.liangyumingblog.memory.Monitor;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class WindowsMemMonitor implements MemInfo {

    private OperatingSystemMXBean osmxb;

    public WindowsMemMonitor() {
        osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
    }

    @Override
    public long getTotal() {
        return osmxb.getTotalPhysicalMemorySize();
    }

    @Override
    public long getFree() {
        return osmxb.getFreePhysicalMemorySize();
    }
}
