import java.util.*;

class Solution {

    // Next Smaller Element
    private int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }

        return ans;
    }

    // Previous Smaller or Equal Element
    private int[] findPSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        return ans;
    }

    // Next Greater Element
    private int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }

        return ans;
    }

    // Previous Greater or Equal Element
    private int[] findPGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        return ans;
    }

    // Sum of all subarray minimums
    private long calcMin(int[] nums) {

        int n = nums.length;

        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int left = i - pse[i];
            int right = nse[i] - i;

            long freq = 1L * left * right;

            sum += freq * nums[i];
        }

        return sum;
    }

    // Sum of all subarray maximums
    private long calcMax(int[] nums) {

        int n = nums.length;

        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int left = i - pge[i];
            int right = nge[i] - i;

            long freq = 1L * left * right;

            sum += freq * nums[i];
        }

        return sum;
    }

    public long subArrayRanges(int[] nums) {

        long maxSum = calcMax(nums);
        long minSum = calcMin(nums);

        return maxSum - minSum;
    }
}