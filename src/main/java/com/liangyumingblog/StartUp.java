package com.liangyumingblog;

import com.liangyumingblog.cpu.CPUMonitorExecutor;
import com.liangyumingblog.memory.MemMonitorExecutor;

import java.lang.reflect.Field;

public class StartUp {

    static {


    }

    public static void main(String[] args) {

        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            StringBuilder builder = new StringBuilder();
            for (String s : paths) {
                builder.append(s);
                builder.append(";");
            }
            String path = StartUp.class.getResource("/").getPath();
            path = path.substring(1);
            path = path.replace("/", "\\");
            builder.append(path);
            builder.append("DLL;");
            field.set(null, builder.toString().split(";"));
            System.setProperty("java.library.path", builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Executor CPUMonitor = new CPUMonitorExecutor();
        Executor memoryMonitor = new MemMonitorExecutor();
        CPUMonitor.execute();
        memoryMonitor.execute();
    }
}
