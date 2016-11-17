package com.liangyumingblog.logger;


import java.text.SimpleDateFormat;
import java.util.Date;

public final class LoggerImpl implements Logger {
    private final static Logger logger = new LoggerImpl();

    private LoggerImpl() {
    }

    public static Logger getInstance() {
        return logger;
    }

    @Override
    public void log(String content) {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(now) + " logger :" + content);
    }
}
