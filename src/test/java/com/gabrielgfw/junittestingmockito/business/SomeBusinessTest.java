package com.gabrielgfw.junittestingmockito.business;

import com.gabrielgfw.junittestingmockito.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {1, 2, 3});
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1, 2, 3});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumWithDataService();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumWithDataService();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] { 1 });
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumWithDataService();
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
