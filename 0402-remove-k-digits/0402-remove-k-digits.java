import java.util.Stack;

class Solution {

    public String removeKdigits(String nums, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < nums.length(); i++) {

            char digit = nums.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        // If k is still remaining, remove from the end
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();

        // Stack → String
        for (char c : st) {
            res.append(c);
        }

        // Remove leading zeros
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        if (i == res.length()) {
            return "0";
        }

        return res.substring(i);
    }
}