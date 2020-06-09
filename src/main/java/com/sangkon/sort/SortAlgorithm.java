package com.sangkon.sort;

public interface SortAlgorithm {
    <T extends Comparable<T>> T[] sort(T[] unsorted);
}
