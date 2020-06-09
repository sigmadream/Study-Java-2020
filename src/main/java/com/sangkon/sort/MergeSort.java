package com.sangkon.sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        T[] array = (T[]) new Comparable[unsorted.length];
        array = MergeSort.mergesort(unsorted);
        return array;
    }

    public static <T extends Comparable<T>> T[] mergesort(T[] ar) {
        int n = ar.length;
        if (n <= 1) return ar;

        T[] left = mergesort(Arrays.copyOfRange(ar, 0, n / 2));
        T[] right = mergesort(Arrays.copyOfRange(ar, n / 2, n));

        return merge(left, right);
    }

    private static <T extends Comparable<T>> T[] merge(T[] ar1, T[] ar2) {
        int n1 = ar1.length, n2 = ar2.length;
        int n = n1 + n2, i1 = 0, i2 = 0;
        T[] ar = (T[]) new Comparable[n];

        for (int i = 0; i < n; i++) {
            if (i1 == n1) {
                ar[i] = ar2[i2++];
            } else if (i2 == n2) {
                ar[i] = ar1[i1++];
            } else {
                if (ar1[i1].compareTo(ar2[i2]) <= 0) {
                    ar[i] = ar1[i1++];
                } else {
                    ar[i] = ar2[i2++];
                }
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        Integer[] intUnSort = {10, 4, 6, 4, 8, -13, 2, 3};
        System.out.println(java.util.Arrays.toString(mergeSort.sort(intUnSort)));

        Double[] doubleUnSort = {10.0, 4.0, 6.0, 4.0, 8.0, -13.0, 2.0, 3.0};
        System.out.println(java.util.Arrays.toString(mergeSort.sort(doubleUnSort)));

        Character[] charUnSort = {'A', 'a', 'B', 'Z', 'z'};
        System.out.println(java.util.Arrays.toString(mergeSort.sort(charUnSort)));
    }

}
