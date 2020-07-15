package com.company;

import java.util.HashSet;
import java.util.Set;
//通过Set集合的特性使得每个加不进集合里的数字就是重复的数字
class offer031 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
//原地置换方法 因为他数字的范围在0~n-1，那么就先读第一个数字
//第一个数字的值不是0，那么就去找这个num[第一个数字]看看两者是否相同
//如果相同就返回，不相同的话就交换，那么num[第一个数字]处就变成了第一个数字的值
//然后num[0]为0
class offer032{
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){

                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}

class offer041 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix[0].length==0){
            return false;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here


    }
}
