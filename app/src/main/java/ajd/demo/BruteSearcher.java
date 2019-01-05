package ajd.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteSearcher {
    public static boolean bruteSearch(int[] arr, List<String> exp) {
        exp.clear();
        for (int cc = 0; cc < Permutation.FAC[4]; cc++) {
            int[] idx = Permutation.codel(cc, 4);
            String a = String.valueOf(arr[idx[0]]);
            String b = String.valueOf(arr[idx[1]]);
            String c = String.valueOf(arr[idx[2]]);
            String d = String.valueOf(arr[idx[3]]);
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < 4; k++) {
                        String X = Point24.OPS[i];
                        String Y = Point24.OPS[j];
                        String Z = Point24.OPS[k];
                        for (String[] ee : new String[][]{
                                {a, b, X, c, Y, d, Z},
                                {a, b, c, X, Y, d, Z},
                                {a, b, X, c, d, Y, Z},
                                {a, b, c, X, d, Y, Z},
                                {a, b, c, d, X, Y, Z},
                        }) {
                            if (Evaluator.eval(ee) == Point24.GOAL) {
                                exp.addAll(Arrays.asList(ee));
                                return true;
                            }
                        }

                    }

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
