package com.liangyumingblog.memory;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MemoryTest {
    @Test
    public void testGetInUsed() throws Exception {
        Memory memory = new Memory(4096L);
        memory.setFree(1000L);
        Method method = Memory.class.getDeclaredMethod("getInUsed");
        method.setAccessible(true);
        Assert.assertTrue(method.invoke(memory).equals(4096L - 1000L));
    }

    @Test
    public void testConstruct() throws Exception {
        Memory memory = new Memory(4096L);
        Field field = Memory.class.getDeclaredField("total");
        field.setAccessible(true);
        Assert.assertTrue(field.get(memory).equals(4096L));
    }

    @Test
    public void testUsedRate() throws Exception {
        Memory memory = new Memory(1000L);
        memory.setFree(500L);
        Method method = Memory.class.getDeclaredMethod("getUseRate");
        method.setAccessible(true);
        Assert.assertTrue(Double.compare((double) method.invoke(memory), (((1000L - 500L) / (double) 1000L))) == 0);
    }
}
