class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        if (left == -1) {
            return new int[] { -1, -1 };
        }

        int right = findRight(nums, target);
        return new int[] { left, right };
    }

    private int findLeft(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    private int findRight(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }
}