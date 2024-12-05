package com.algorithm.leetcode;

import com.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test0922 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> pl = pl(nums);
        System.out.println(pl.size());

    }

    public List<List<TreeNode>> nodePath(TreeNode root) {
        List<TreeNode> state = new ArrayList<>();
        List<List<TreeNode>> result = new ArrayList<>();
        doNodePath(root, state, result);
        return result;
    }

    public void doNodePath(TreeNode node, List<TreeNode> state, List<List<TreeNode>> result) {
        if (node == null) {
            return;
        }
        state.add(node);
        if (node.value == 7) {
            result.add(new ArrayList<>(state));
        }
        doNodePath(node.left, state, result);
        doNodePath(node.right, state, result);
        state.remove(state.size() - 1);
    }

    public static List<List<Integer>> pl(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        List<Integer> state = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dp[i] = false;
        }
        doPl(nums, dp, state, result);
        return result;
    }

    public static void doPl(int[] nums, boolean[] dp, List<Integer> state, List<List<Integer>> result) {
        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) {
                state.add(nums[i]);
                dp[i] = true;
                doPl(nums, dp, state, result);
                state.remove(state.size() - 1);
                dp[i] = false;
            }

        }
    }

    /*private Integer hh(int n) {}

    private boolean checkLocation(boolean[][] selected, int x ,int j) {

    }*/



}
