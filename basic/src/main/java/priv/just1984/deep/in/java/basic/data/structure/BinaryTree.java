package priv.just1984.deep.in.java.basic.data.structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-11 11:31
 */
public class BinaryTree {

    public static <T> TreeNode<T> of(T... source) {
        return ofArray(source);
    }

    public static <T> TreeNode<T> ofArray(T[] arr) {
        return ofLinkedList(new LinkedList<>(Arrays.asList(arr)));
    }

    public static <T> TreeNode<T> ofLinkedList(LinkedList<T> l) {
        if (l.isEmpty()) {
            return null;
        }
        T data = l.remove();
        if (data == null) {
            return null;
        }
        TreeNode<T> node = new TreeNode<>(data);
        node.left = ofLinkedList(l);
        node.right = ofLinkedList(l);
        return node;
    }

    public static <T> void preOrder(TreeNode<T> root, Consumer<T> consumer) {
        if (root == null) {
            return;
        }
        consumer.accept(root.data);
        preOrder(root.left, consumer);
        preOrder(root.right, consumer);
    }

    public static <T> void midOrder(TreeNode<T> root, Consumer<T> consumer) {
        if (root == null) {
            return;
        }
        midOrder(root.left, consumer);
        consumer.accept(root.data);
        midOrder(root.right, consumer);
    }

    public static <T> void postOrder(TreeNode<T> root, Consumer<T> consumer) {
        if (root == null) {
            return;
        }
        postOrder(root.left, consumer);
        postOrder(root.right, consumer);
        consumer.accept(root.data);
    }

    public static <T> void preOrderWithStack(TreeNode<T> root, Consumer<T> consumer) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                consumer.accept(root.data);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static <T> void midOrderWithStack(TreeNode<T> root, Consumer<T> consumer) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                consumer.accept(root.data);
                root = root.right;
            }
        }
    }

}
