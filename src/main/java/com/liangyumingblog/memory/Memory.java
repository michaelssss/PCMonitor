package com.liangyumingblog.memory;

class Memory {
    private long inUsed;

    private long free;

    private long total;

    private double useRate;

    Memory(long total) {
        this.total = total;
    }

    private long getInUsed() {
        return total - free;
    }

    private long getFree() {
        return free;
    }

    void setFree(long free) {
        this.free = free;
    }

    private long getTotal() {
        return total;
    }

    private double getUseRate() {
        return (total - free) / (double) total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;

        Memory memory = (Memory) o;

        if (inUsed != memory.inUsed) return false;
        if (free != memory.free) return false;
        if (total != memory.total) return false;
        return Double.compare(memory.useRate, useRate) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (inUsed ^ (inUsed >>> 32));
        result = 31 * result + (int) (free ^ (free >>> 32));
        result = 31 * result + (int) (total ^ (total >>> 32));
        temp = Double.doubleToLongBits(useRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "inUsed=" + getInUsed() / (1024 * 1024) +
                ", free=" + getFree() / (1024 * 1024) +
                ", total=" + getTotal() / (1024 * 1024) +
                ", useRate=" + String.format("%.2f", getUseRate()) +
                '}';
    }
}
