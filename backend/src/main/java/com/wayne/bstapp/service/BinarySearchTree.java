package com.wayne.bstapp.service;


import com.wayne.bstapp.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.getValue()) node.setLeft(insertRecursive(node.getLeft(), value));
        else if (value > node.getValue()) node.setRight(insertRecursive(node.getRight(), value));
        return node;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null) return false;
        if (value == node.getValue()) return true;
        return value < node.getValue()
                ? searchRecursive(node.getLeft(), value)
                : searchRecursive(node.getRight(), value);
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.getLeft(), result);
            result.add(node.getValue());
            inOrderHelper(node.getRight(), result);
        }
    }
}

