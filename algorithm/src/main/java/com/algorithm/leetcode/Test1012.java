package com.algorithm.leetcode;

public class Test1012 {

    private Integer bag(int cap, int i, int[] val, int[] weight) {
        int[][] dp = new int[cap + 1][i + 1];

        //任务初始状态
        for (int j = 0; j <= cap; j++) {
            dp[j][0] = 0;
        }
        for (int j = 0; j <= i; j++) {
            dp[0][j] = 0;
        }
        for (int c = 1; c <= cap; c++) {
            for (int offset = 1; offset <= i; offset++) {
                if (c < weight[i - 1]) {
                    dp[c][offset] = dp[c][offset - 1];
                } else {
                    dp[c][offset] = Math.max(dp[c][offset - 1], (dp[c - weight[i - 1]][offset - 1] + val[i - 1]));
                }
            }
        }
        return dp[cap][i];
    }
}
