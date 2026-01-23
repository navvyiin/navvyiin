class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        // Control should never reach here
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}