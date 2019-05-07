package cn.com.polycis.TreeNode2;

public class Solution2 {

    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
       TreeNode treeNode = reConstructBinaryTree(preorder, inorder);
        System.out.println(treeNode);
    }


    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //调用递归
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //越界就返回null
        if(startPre > endPre || startIn > endIn) {
            return null;
        }
        //前序遍历的起始点就是根结点
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = 0; i <= endIn; i++) {
            if(pre[startPre] == in[i]) {//根据前序遍历得到的根结点在中序遍历中查找根结点的下标i
                //重点，里面的起始值和结束值
                //左子树：前序遍历中起始值为之前的起始值加一，终点值为前序起始值加上（中序的根值i-中序的起始值，即得到左子树个数）
                //	  中序遍历中起始值为之前中序起始值，终点值为中序根结点减一即i-1
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //右子树：前序遍历中起始值为前序起始值加上左子树个数（i-startIn）再加1，终点值为前序的终点值。
                //	  中序遍历中起始值为中序根结点加一（i+1），终点值为之前中序的终点值
                root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }



}
