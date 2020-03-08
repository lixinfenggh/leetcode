package p322_coin_change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) return 0;
        int[] coinsNum = new int[amount+1];
        Arrays.fill(coinsNum, Integer.MIN_VALUE);
        Solution.getCoinsNum(coins, amount, coinsNum);
        return coinsNum[amount];
    }

    private static void getCoinsNum(int[] coins, int amount, int[] coinsNum) {
        if (amount < 0) return;
        if (amount < coins[0]) {
            coinsNum[amount] = -1;
            return;
        }
        if (coinsNum[amount] >= -1) return;
        if (Solution.halfSearch(coins, amount) != -1) {
            coinsNum[amount] = 1;
            return;
        }
        int[] minNum = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                minNum[i] = -1;
                continue;
            } else if (coinsNum[amount-coins[i]] <= 0)
                Solution.getCoinsNum(coins, amount-coins[i], coinsNum);
            minNum[i] = coinsNum[amount-coins[i]];
        }
        int min = amount;
        for (int value : minNum) {
            if (value != -1 && value < min)
                min = value;
        }
        coinsNum[amount] = min == amount ? -1 : min + 1;
    }

    // 该函数来源：https://blog.csdn.net/Xin6Yang/article/details/88778033
    private static int halfSearch(int[] arr, int key) {
        int min, max, mid;
        min = 0;    //  数组最小索引值
        max = arr.length - 1;    // 数组最大索引值
        mid = (min + max) / 2;    // 数组中间索引值

        while (arr[mid] != key) {
            if (arr[mid] > key) {
                max = mid - 1;
            }
            if (arr[mid] < key) {
                min = mid + 1;
            }
            // 查找完毕，该数组没有该元素返回-1
            if (min > max) {
                return -1;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}