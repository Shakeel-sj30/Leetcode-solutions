class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long required = (long) m * k;

        // Not enough flowers
        if (required > bloomDay.length) {
            return -1;
        }

        int low = 1;
        int high = 0;

        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid - 1;   // Try fewer days
            } else {
                low = mid + 1;    // Need more days
            }
        }

        return low;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int consecutive = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }

            } else {
                consecutive = 0;
            }
        }

        return false;
    }
}