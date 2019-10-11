package priv.just1984.deep.in.java.demo.data.demo;

import priv.just1984.deep.in.java.demo.data.structure.BinaryTree;
import priv.just1984.deep.in.java.demo.data.structure.TreeNode;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-11 11:30
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode<Integer> root = BinaryTree.of(3, 1, 5, 7, null, null, 9, null, null, null, 2, 4, null, null, 8, null, null);
        BinaryTree.preOrderWithStack(root, System.out::println);
    }

}
