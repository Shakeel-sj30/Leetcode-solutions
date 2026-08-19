class Solution {

    public int[] searchRange(int[] nums, int target) {

        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);

        // Target not found
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub - 1};
    }

    // First index where nums[i] >= target
    public int lowerBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // First index where nums[i] > target
    public int upperBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}