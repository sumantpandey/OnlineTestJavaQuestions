package com.sumant.arrays;

public class FloodDepth {

    public int solution(int[] A) {
        int result = 0;
        int maxDepthUntillNow = -1;
        int minBetween = -1;
        int prev = -1;
        for (int current : A) {
            if (current > maxDepthUntillNow) {
                result = getresult(maxDepthUntillNow, current, minBetween, result);
                maxDepthUntillNow = current;
                minBetween = current;
            }
            if (current > prev)
                result = getresult(maxDepthUntillNow, current, minBetween, result);

            if (current < minBetween)
                minBetween = current;
            prev = current;
        }
        return result;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

    public int getresult(int first, int second, int minBetween, int result) {
        int tempresult = min(first, second) - minBetween;
        return tempresult > result ? tempresult : result;
    }
}
