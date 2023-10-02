package com.gabrielgfw.junittestingmockito.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ListMockTest {
    List mock = Mockito.mock(List.class);

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
}
