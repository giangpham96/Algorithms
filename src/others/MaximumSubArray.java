package others;

/**
 * find a maximum sub array of a given array
 * there are two ways to achieve this:
 * {@link MaximumSubArray#linear(int[])}
 * and {@link MaximumSubArray#recursive(int[])}
 */

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int[] arr = new int[]{13, -3, 14, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
        };
        SubArrayInfo linear = maximumSubArray.linear(arr);
        System.out.print("linear:\t" + linear.sum);

        SubArrayInfo recursive = maximumSubArray.recursive(arr);
        System.out.print("\nrecursive:\t" + recursive.sum);
    }

    /*
    linear is faster compare to recursive,
    it is a non-recursive, linear (O(n)-time) algorithm
     */
    public SubArrayInfo linear(int[] array) {
        int maxSum = array[0];
        int maxSumEndAt_i = array[0];
        int start = 0, end = 0;
        for (int i = 1; i < array.length; i++) {
            if (maxSumEndAt_i + array[i] < array[i]) {
                maxSumEndAt_i = array[i];
                start = i;
            } else {
                maxSumEndAt_i += array[i];
            }

            if (maxSum < maxSumEndAt_i) {
                maxSum = maxSumEndAt_i;
                end = i;
            }
        }
        return new SubArrayInfo(start, end, maxSum);
    }

    /*
    recursive way is slower,
    it is an O(n lg n)-time algorithm
     */
    public SubArrayInfo recursive(int[] array) {
        return maximumSubArray(array, 0, array.length - 1);
    }

    private SubArrayInfo maximumSubArray(int[] array, int start, int end) {
        if (start == end) {
            return new SubArrayInfo(start, end, array[start]);
        }
        int mid = (start + end) / 2;
        SubArrayInfo left = maximumSubArray(array, start, mid);
        SubArrayInfo right = maximumSubArray(array, mid + 1, end);
        SubArrayInfo cross = maxCrossingSubArray(array, start, mid, end);

        if (left.compareTo(right) >= 0 && left.compareTo(cross) >= 0) {
            return left;
        }
        if (right.compareTo(left) >= 0 && right.compareTo(cross) >= 0) {
            return right;
        }
        return cross;
    }

    private SubArrayInfo maxCrossingSubArray(int[] array, int start, int crossPoint, int end) {
        int leftSum = array[crossPoint], rightSum = array[crossPoint + 1];
        int sum = 0;
        int low = crossPoint, high = crossPoint + 1;

        for (int i = crossPoint; i >= start; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                low = i;
            }
        }

        sum = 0;

        for (int i = crossPoint + 1; i <= end; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                high = i;
            }
        }

        return new SubArrayInfo(low, high, leftSum + rightSum);
    }

    public static class SubArrayInfo implements Comparable<SubArrayInfo> {
        private int start;
        private int end;
        private int sum;

        SubArrayInfo(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        public SubArrayInfo() {
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(SubArrayInfo o) {
            return Integer.compare(this.sum, o.sum);
        }
    }
}
