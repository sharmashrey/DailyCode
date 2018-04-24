package com.company;

import com.company.TreeNode;

public class checkTreeisBST {


    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.leftChild, minVal, root.val) && isValidBST(root.rightChild, root.val, maxVal);
    }
    public static void main(String[] args) {

    }

}
