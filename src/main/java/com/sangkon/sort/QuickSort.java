package com.sangkon.sort;

public class QuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) >>> 1;
        T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        Integer[] intUnSort = {10, 9, 8, 7, 6, 1, 2, 3, 4, 5};
        System.out.println(java.util.Arrays.toString(quickSort.sort(intUnSort)));

        Double[] doubleUnSort = {10.1, 9.2, 8.3, 7.4, 6.5, 1.6, 2.7, 3.8, 4.9, 5.0};
        System.out.println(java.util.Arrays.toString(quickSort.sort(doubleUnSort)));

        Character[] charUnSort = {'A', 'a', 'B', 'Z', 'z'};
        System.out.println(java.util.Arrays.toString(quickSort.sort(charUnSort)));
    }
}
