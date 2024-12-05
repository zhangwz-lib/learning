package com.algorithm.leetcode;

public class Test0925 {

    private Integer lt(int[] cost, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[n] = cost[n];
                continue;
            }
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[n];
    }
}
