package com.sangkon.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

class SortAlgorithmTest {
    enum SortingAlgorithm {
        MERGE_SORT(new MergeSort()),
        QUICK_SORT(new QuickSort());

        private SortAlgorithm sortAlgorithm;

        SortingAlgorithm(SortAlgorithm sortAlgorithm) {
            this.sortAlgorithm = sortAlgorithm;
        }

        public SortAlgorithm getSortingAlgorithm() {
            return sortAlgorithm;
        }
    }

    private final EnumSet<SortingAlgorithm> sortingAlgorithms =
            EnumSet.of(SortingAlgorithm.MERGE_SORT, SortingAlgorithm.QUICK_SORT);

    @Test
    public void verifySortingAlgorithms() {
        for (SortingAlgorithm algorithm : sortingAlgorithms) {
            SortAlgorithm sorter = algorithm.getSortingAlgorithm();
            Integer[] intUnSort = {10, 4, 6, 4, 8, -13, 2, 3};
            Integer[] copyIntUnSort = intUnSort.clone();
            Arrays.sort(intUnSort);
            Double[] doubleUnSort = {10.0, 4.0, 6.0, 4.0, 8.0, -13.0, 2.0, 3.0};
            Double[] copyDoubleUnSort = doubleUnSort.clone();
            Arrays.sort(doubleUnSort);
            assertThat(intUnSort).isEqualTo(sorter.sort(copyIntUnSort));
            assertThat(doubleUnSort).isEqualTo(sorter.sort(copyDoubleUnSort));
        }
    }
}