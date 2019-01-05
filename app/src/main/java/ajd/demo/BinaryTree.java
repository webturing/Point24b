package ajd.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.createTree("5 1 5 / - 5 *".split(" "));
        tree.midVisit();
        System.out.println();
        StringBuffer buffer = new StringBuffer();
        tree.midVisit(buffer);
        System.out.println(buffer);
    }

    public static BinaryTree createTree(String[] exp) {
        return createTree(Arrays.asList(exp));
    }

    public static BinaryTree createTree(List<String> exp) {
        Stack<BinaryTree> stack = new Stack<>();
        for (String s : exp) {
            BinaryTree b = new BinaryTree(s);
            if (Evaluator.isNumber(s)) {
                stack.push(b);
            } else if (Evaluator.isOperator(s)) {
                BinaryTree right = stack.pop();
                BinaryTree left = stack.pop();
                b.setLeft(left);
                b.setRight(right);
                stack.push(b);
            }
        }
        return stack.peek();
    }


    void midVisit() {
        System.out.print("(");
        if (left != null)
            left.midVisit();
        System.out.print(root);
        if (right != null)
            right.midVisit();
        System.out.print(")");
    }

    boolean isEmpty() {
        return left == null && right == null;
    }

    void midVisit(StringBuffer buffer) {
        if (braced)
            buffer.append("(");
        if (left != null)
            left.midVisit(buffer);
        buffer.append(root);
        if (right != null)
            right.midVisit(buffer);
        if (braced)
            buffer.append(")");
    }

    public BinaryTree(String root) {
        this(root, null, null);
    }

    public BinaryTree(String root, BinaryTree left, BinaryTree right) {
        this.root = root;
        if (left != null)
            this.setLeft(left);
        if (right != null)
            this.setRight(right);
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
        left.braced = Evaluator.less(left.root, root);
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
        right.braced = Evaluator.lessOrEqual(root, right.root);
    }

    String root;
    BinaryTree left;
    BinaryTree right;
    boolean braced = false;
}
