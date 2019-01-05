package ajd.demo;

import java.util.ArrayList;
import java.util.List;

public class Point24 {
    public static final double GOAL = 24.0;
    public final static String[] OPS = "+ - * /".split(" ");
    public static void main(String[] args) {
        System.out.println(solve(new int[]{192, 2, 2, 2}));
    }

    public static String solve(int[] a) {
        List<String> exp = new ArrayList<>();
        if (RandomSearcher.randSearch(a, exp)) {
            StringBuffer buffer = new StringBuffer();
            BinaryTree binaryTree = BinaryTree.createTree(exp);
            binaryTree.midVisit(buffer);
            return buffer.toString();
        } else {
            return "no solutions!";
        }
    }
}
