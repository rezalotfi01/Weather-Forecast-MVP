package com.github.rezalotfi01.forecast.data.memory;


public class MemoryItem<T> {

    private long validationPeriod;
    private long timeStamp;
    private T item;

    public MemoryItem(T item, long validationPeriod) {

        this.item = item;
        this.validationPeriod = validationPeriod;
        timeStamp = System.currentTimeMillis();
    }

    public T getItem() {

        return item;
    }

    public boolean isValid() {

        return validationPeriod == MemoryCache.VALIDATION_INFINITY
                || timeStamp + validationPeriod >= System.currentTimeMillis();
    }

}