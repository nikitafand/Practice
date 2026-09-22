package coding;


import java.util.ArrayList;
import java.util.List;

public class MaximumThroughput {

    /*
     * Complete the 'getMaximumThroughput' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY throughput
     *  2. INTEGER_ARRAY scalingCost
     *  3. INTEGER budget
     */

    public static long getMaximumThroughput(List<Integer> throughput, List<Integer> scalingCost, int budget) {
        long low = 1;
        // Based on constraints, the maximum possible throughput is 10^9
        long high = 1_000_000_000L;
        long maxThroughput = 0;

        // Binary search for the maximum possible bottleneck throughput
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canAchieve(mid, throughput, scalingCost, budget)) {
                maxThroughput = mid; // This throughput is valid, save it
                low = mid + 1;       // Try to find a higher throughput
            } else {
                high = mid - 1;      // This throughput is too expensive, lower the target
            }
        }

        return maxThroughput;
    }

    private static boolean canAchieve(long targetThroughput, List<Integer> throughput, List<Integer> scalingCost, int budget) {
        long currentCost = 0;

        for (int i = 0; i < throughput.size(); i++) {
            long currentThroughput = throughput.get(i);

            // If the current service's throughput is less than our target, we must scale it
            if (currentThroughput < targetThroughput) {

                // We need: currentThroughput * (1 + x) >= targetThroughput
                // Which means: 1 + x >= ceil(targetThroughput / currentThroughput)
                // Integer division trick for ceiling: (A + B - 1) / B
                long requiredMultiplier = (targetThroughput + currentThroughput - 1) / currentThroughput;

                // The number of times we need to scale is (multiplier - 1)
                long x = requiredMultiplier - 1;

                // Add the cost to scale this specific service
                currentCost += x * scalingCost.get(i);

                // Early exit: if the cost exceeds the budget at any point, this target is impossible
                if (currentCost > budget) {
                    System.out.println("Required multiplier: " + requiredMultiplier);
                    return false;
                }
            }
        }

        return currentCost <= budget;
    }

    public static void main(String[] args) {
        List<Integer> throughput = new ArrayList<>(List.of(4, 2, 7));
        List<Integer> scalingCost = new ArrayList<>(List.of(3, 5, 6));
        int budget = 32;
        long maximumThroughput = getMaximumThroughput(throughput, scalingCost, budget);
        System.out.println(maximumThroughput);
    }
}
