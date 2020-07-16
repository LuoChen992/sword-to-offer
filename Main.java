package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
//最简单最基础的方法，使用暴力查找
class offer041 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
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

//根据从左到右 从上到下依次增大的规律 来构建
class offer042 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}


//先计算出链表的长度，然后直接赋值给数组返回。
class offer061 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        ListNode currentnode=head;
        int len=0;
        while (currentnode!=null){
            len++;
            currentnode=currentnode.next;
        }
        int Array[]=new int[len];

        currentnode=head;
        for(int i=0;i<len;i++){
            Array[len-1-i]=currentnode.val;
            currentnode=currentnode.next;
        }
        return  Array;
    }
}

//直接用栈
class offer062 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop();
        }
        return print;
    }
}
//
public class Main {

    public static void main(String[] args) {
	// write your code here


    }
}
