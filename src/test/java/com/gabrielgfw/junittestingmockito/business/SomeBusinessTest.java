package com.gabrielgfw.junittestingmockito.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {1, 2, 3});
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
