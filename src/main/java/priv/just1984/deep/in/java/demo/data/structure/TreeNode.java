package priv.just1984.deep.in.java.demo.data.structure;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-11 11:25
 */
public class TreeNode<T> extends DataNode<T> {

    public TreeNode<T> left;

    public TreeNode<T> right;

    public TreeNode(T data) {
        super(data);
    }

}
