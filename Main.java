package com.company;

import java.util.*;

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

class offer05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
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
//通过前序遍历和中序遍历根据递推来重建二叉树
//具体就是通过每一次得到根节点
class offer071 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    HashMap<Integer,Integer> dic=new HashMap<>();
    int []po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po=preorder;
        for(int i = 0; i <inorder.length ; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left>in_right)return null;
        TreeNode root=new TreeNode(po[pre_root]);
        int i=dic.get(po[pre_root]); //中序遍历中的根节点的索引
        root.left=recur(pre_root+1,in_left,i-1);
        root.right=recur(pre_root+1+i-in_left,i+1,in_right);
        //这里的右子树的根节点索引:到前序遍历里面去看,
        return root;
    }
}
//
class offer091 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
         stack1=new Stack<>();
         stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
// dp动态规划
class offer010-1 {
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        int dp[]=new int[n];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n;i++){
        dp[i]=dp[i-1]+dp[i-2];
        dp[i]%=1000000007;
        }
        return (dp[n-1]+dp[n-2])%1000000007;

    }
}
class offer111 {
    public int minArray(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]<numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
//二叉树镜像方法1：用递归的方法
class offer271 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode temp=new TreeNode(0);
        if (root==null){
            return null;
        }
        temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(root.left);
        return root;
    }
}
//二叉树镜像方法2：用队列或栈的方法
class offer272 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mirrorTree(TreeNode root) {

        if (root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}

//顺时针打印
class offer291 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new int[0];
        int l=0,r=matrix[0].length-1,t=0,b= matrix.length-1;
        int x=0;
        int[] print=new int[(r+1)*(b+1)];
        while (true){
            //第一行从左往右
            for (int i = l; i <=r ; i++) {
                print[x++]=matrix[t][i];
            }
            t++;  //将top往下移一层
            if(t>b)break;

            //第二次 从上到下
            for (int i = t; i <= b; i++) {
                print[x++]=matrix[i][r];
            }
            r--;
            if(r<l)break;

            //第三次 从右往左
            for (int i = r; i >= l; i--) {
                print[x++]=matrix[b][i];
            }
            b--;
            if(b<t)break;

            //
            for (int i = b; i >=t ; i--) {
                print[x++]=matrix[i][l];
            }
            l++;
            if(l>r)break;
        }
        return print;
    }
}

class offer241 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){return head;}

        ListNode cur=reverseList(head.next);
        head.next.next=head;
        head.next=null;

        return cur;
    }
}

class offer242 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode tmp=null;
        while(cur!=null){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
}

class offer181 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp=null;
        if(head==null)return head;
        if(head.val==val){ //头结点的情况
            return head.next;

        }
        ListNode cur=head.next;
        ListNode pre=head;
        while(cur!=null){
            if(cur.val==val){
                if(cur.next==null){  //尾结点的情况
                    pre.next=null;
                }
                pre.next=cur.next;
            }
            pre=cur;
            cur=cur.next;

        }
        return head;
    }
}
//
public class Main {

    public static void main(String[] args) {
	// write your code here


    }
}
