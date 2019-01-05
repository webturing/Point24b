package ajd.demo;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point24 {
    public static final double GOAL = 24.0;
    public final static String[] OPS = "+ - * /".split(" ");

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new File("24solve.txt"));
        int a[] = new int[4];
        for (a[0] = 0; a[0] <= 9; ++a[0])
            for (a[1] = a[0]; a[1] <= 9; ++a[1])
                for (a[2] = a[1]; a[2] <= 9; ++a[2])
                    for (a[3] = a[2]; a[3] <= 9; ++a[3]) {
                        pw.println("" + a[0] + a[1] + a[2] + a[3] + "\t" + solve(a));
                    }
        pw.close();
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
