package zui_xiao_de_kge_shu_lcof;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int [] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}