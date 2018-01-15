package problems;

import sorting.MergeSort;
import search.BinarySearch;

/**
 * answers to problems from 'Introduction to algorithms' third edition
 */

public class IntroductionToAlgorithms {
    public static void main(String[] args) {

    }

    /* 2.3-7
    Describe a O(n lg n)-time algorithm that, given a set S of n integers and another
    integer x, determines whether or not there exist two elements in S whose sum is
    exactly x.
    */

    private static boolean e2_3__7(int[] S, int x) {

        MergeSort mergeSort = new MergeSort();
        S = mergeSort.sort(S);

        BinarySearch binarySearch = new BinarySearch();

        int y;
        for (int element : S) {
            y = x - element;
            if (binarySearch.search(S, y) >= 0) {
                return true;
            }
        }

        return false;
    }

}
