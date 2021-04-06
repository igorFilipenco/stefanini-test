package com.stefanini.test3;

import org.junit.Test;

public class TaskManagerAppTest {
    @Test(expected = IllegalArgumentException.class)
    public void testMainWithNoArgsPassed() {
        TaskManagerApp.main(new String[] {});
    }
}