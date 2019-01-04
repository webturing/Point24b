package ajd.demo;

import java.util.ArrayList;
import java.util.List;

public class Point24 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 14}));
    }

    public static String solve(int[] a) {
        List<String> exp = new ArrayList<>();
        if (Searcher.searchAnswer(a, exp)) {
            StringBuffer buffer = new StringBuffer();
            BinaryTree binaryTree = BinaryTree.createTree(exp);
            binaryTree.midVisit(buffer);
            return buffer.toString();
        } else {
            return "no solutions!";
        }
    }
}
