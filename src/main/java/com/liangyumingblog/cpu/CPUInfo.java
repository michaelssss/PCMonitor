package com.liangyumingblog.cpu;

class CPUInfo {
    private int coreNum;

    private float useRate;

    private String CPUName;

    public CPUInfo(int coreNum, String CPUName) {
        this.coreNum = coreNum;
        this.CPUName = CPUName;
    }

    public int getCoreNum() {
        return coreNum;
    }

    public float getUseRate() {
        return useRate;
    }

    public void setUseRate(float useRate) {
        this.useRate = useRate;
    }

    public String getCPUName() {
        return CPUName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPUInfo)) return false;

        CPUInfo cpuInfo = (CPUInfo) o;

        if (coreNum != cpuInfo.coreNum) return false;
        if (Float.compare(cpuInfo.useRate, useRate) != 0) return false;
        return CPUName != null ? CPUName.equals(cpuInfo.CPUName) : cpuInfo.CPUName == null;

    }

    @Override
    public int hashCode() {
        int result = coreNum;
        result = 31 * result + (useRate != +0.0f ? Float.floatToIntBits(useRate) : 0);
        result = 31 * result + (CPUName != null ? CPUName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CPUInfo{" +
                "coreNum=" + coreNum +
                ", useRate=" + useRate + "" +
                ", \nCPUName='\n" + CPUName + '\'' +
                '}';
    }
}
