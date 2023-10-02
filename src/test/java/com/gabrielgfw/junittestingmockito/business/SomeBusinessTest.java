package com.gabrielgfw.junittestingmockito.business;

import com.gabrielgfw.junittestingmockito.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class SomeBusinessTest {
    @InjectMocks
    SomeBusinessImpl business;
    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSum_basic() {
        Assertions.assertEquals(6, business.calculateSum(new int [] {1, 2, 3}));
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1, 2, 3});
        Assertions.assertEquals(6, business.calculateSumWithDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {});
        Assertions.assertEquals(0, business.calculateSumWithDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int [] { 1 });
        Assertions.assertEquals(1, business.calculateSumWithDataService());
    }
}
