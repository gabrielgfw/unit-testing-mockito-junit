package com.gabrielgfw.junittestingmockito.business;

import com.gabrielgfw.junittestingmockito.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;

        for(int value: data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumWithDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value: data) {
            sum += value;
        }
        return sum;
    }
}
