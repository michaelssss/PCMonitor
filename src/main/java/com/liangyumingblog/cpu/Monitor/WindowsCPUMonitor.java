package com.liangyumingblog.cpu.Monitor;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;

public class WindowsCPUMonitor implements CPUMonitor {
    private Sigar sigar;

    public WindowsCPUMonitor() {
        sigar = new Sigar();
    }

    @Override
    public int getCoreNum() {
        try {
            return sigar.getCpuInfoList().length;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public float getUseRate() {
        try {
            return sigar.getCpu().getSys();

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String getCPUName() {
        CpuInfo[] cpuinfoList = new CpuInfo[0];

        try {
            cpuinfoList = sigar.getCpuInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder(64);
        for (CpuInfo cpuInfo : cpuinfoList) {
            sb.append("CPU:");
            sb.append(cpuInfo.getVendor());
            sb.append(cpuInfo.getModel());
            sb.append("\n");
        }
        return sb.toString();
    }
}
