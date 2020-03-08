package p322_coin_change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) return 0;
        int coinNum = Solution.getCoinsNum(coins, amount, 0);
        if (coinNum == Integer.MAX_VALUE) return -1;
        else return coinNum;
    }

    private static int getCoinsNum(int[] coins, int amount, int coinsNum) {
        if (amount < 0 || amount < coins[0]) return Integer.MAX_VALUE;
        if (Solution.halfSearch(coins, amount) != -1) return coinsNum+1;
        int[] minNum = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            minNum[i] = Solution.getCoinsNum(coins, amount-coins[i], coinsNum+1);
        }
        return Solution.min(minNum);
    }

    private static int min(int[] arr)  {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < min)
                min = value;
        }
        return min;
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
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }
}