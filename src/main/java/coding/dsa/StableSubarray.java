package coding.dsa;

public class StableSubarray {
    public static int longestStableSubarray(int[] arr, int k) {
        int maxLen = 0;

        for (int left = 0; left < arr.length; left++) {
            int min = arr[left];
            int max = arr[left];

            for (int right = left; right < arr.length; right++) {
                min = Math.min(min, arr[right]);
                max = Math.max(max, arr[right]);

                if (max - min <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

}
