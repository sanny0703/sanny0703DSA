package VariableSize;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubArray {

    public static List<Integer>maxSubArray(int[] arr){
        int ans = Integer.MIN_VALUE;
        int cur = 1;
        int start =0,end =0;
        int i=0,j =0;
        while(j<arr.length){
            cur *= arr[j];
            if(cur >ans){
                ans = cur;
                start =i;
                end =j;
            }
            if(cur<0){
                while(cur <0){
                    cur/= arr[i];
                    i++;
                }
            }
            j++;
        }
        List<Integer>list = new ArrayList<>();
        for(int k =start;k<= end;k++){
            list.add(arr[k]);
        }
        System.out.println(ans);
        return list;
    }

    public static void main(String[] args) {
        //180
        System.out.println(maxSubArray(new int[]{6, -3, -10, 0, 2}));
    }
}
