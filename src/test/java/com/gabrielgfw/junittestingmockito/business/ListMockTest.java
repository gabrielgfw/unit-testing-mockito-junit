package com.gabrielgfw.junittestingmockito.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ListMockTest {
    List<String> mock = Mockito.mock(List.class);

    @Test
    public void size_basic() {
        Mockito.when(mock.size()).thenReturn(5);
        Assertions.assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        Mockito.when(mock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5, mock.size());
        Assertions.assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        Mockito.when(mock.get(0)).thenReturn("Werner");
        Assertions.assertEquals("Werner", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        Mockito.when(mock.get(Mockito.anyInt())).thenReturn("Werner");
        Assertions.assertEquals("Werner", mock.get(2));
    }

    @Test
    public void verificationBasics() {
        String value = mock.get(0);
        String value2 = mock.get(0);

        // Checking min number of invocations of specific method (get)
        Mockito.verify(mock, Mockito.atLeast(1)).get(0);
        // Checking number of invocations of specific method (get)
        Mockito.verify(mock, Mockito.times(2)).get(Mockito.anyInt());
        // Checking if the specific argument were never called (parameter in this case)
        Mockito.verify(mock, Mockito.never()).get(3);
    }
}
