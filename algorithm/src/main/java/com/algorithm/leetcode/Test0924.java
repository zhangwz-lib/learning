package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test0924 {
    private Integer lt(int n) {
        int[] choices = new int[]{1, 2};
        Integer state = 0;
        List<Integer> result = new ArrayList<>();
        dolt(choices, state, n, result);
        return result.get(0);
    }

    private void dolt(int[] choice, Integer state, Integer n, List<Integer> result) {
        if (Objects.equals(state, n)) {
            result.set(0, result.get(0) + 1);
            return;
        }
        for (int i : choice) {
            if (state + i > n) {
                break;
            }
            dolt(choice, state, n, result);
        }
    }


}
