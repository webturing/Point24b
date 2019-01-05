package ajd.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteSearcher {


    public static boolean bruteSearch(int[] a, List<String> exp) {
        List<String> exp2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) exp2.add(Integer.toString(a[i]));
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++) {
                    List<String> ops = new ArrayList<String>();
                    ops.add(Point24.OPS[i]);
                    ops.add(Point24.OPS[j]);
                    ops.add(Point24.OPS[k]);
                    exp2.addAll(ops);
                    for (int c = 0; c < Permutation.FAC[7]; c++) {
                        int d = c;
                        int[] idx = Permutation.codel(c, 7);
                        for (int g = 0; g < 7; g++) {
                            exp.add(exp2.get(idx[g]));
                        }
                        if (Evaluator.eval(exp) == Point24.GOAL) {
                            return true;
                        }
                        exp.clear();
                    }
                    exp2.removeAll(ops);
                }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> exp = new ArrayList<>();
        if (bruteSearch(new int[]{5, 5, 5, 1}, exp)) {
            System.out.println(exp);
        }
    }
}
