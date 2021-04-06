package com.stefanini.test3.utils;

import org.junit.Test;

public class ParamsExtractorTest {
    @Test(expected = Exception.class)
    public void testGetOperationNameWithWrongOperationArg() throws Exception {
        ParamsExtractor.getOperationName("-killTask");
    }
}