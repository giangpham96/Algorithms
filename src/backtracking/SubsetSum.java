package backtracking;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum
 */
public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        boolean exist = subsetSum.subsetSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 56);
        System.out.println(exist);
    }

    public boolean subsetSum(int[] set, int sum) {
        return subsetSum(set, set.length - 1, sum);
    }

    private boolean subsetSum(int[] set, int end, int sum) {
        if (sum == 0)
            return true;
        if (end < 0 || sum < 0)
            return false;
        return subsetSum(set, end - 1, sum) || subsetSum(set, end - 1, sum - set[end]);
    }
}
