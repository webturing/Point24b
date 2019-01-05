package ajd.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class RandomSearcher {
    static Random random = new Random();
    public static void main(String[] args) {
        int a[] = {5, 5, 5, 1};
        List<String> result = new ArrayList<>();
        if (randSearch(a, result)) ;
        System.out.println(result);
    }

    public static boolean randSearch(int[] a, List<String> exp) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) exp.add(Integer.toString(a[i]));
        while (true) {
            List<String> ops = new ArrayList<String>();
            ops.add(Point24.OPS[random.nextInt(4)]);
            ops.add(Point24.OPS[random.nextInt(4)]);
            ops.add(Point24.OPS[random.nextInt(4)]);
            exp.addAll(ops);
            Collections.shuffle(exp);
            if (Evaluator.eval(exp) == 24.0) {
                return true;
            }
            exp.removeAll(ops);//细节
            ++cnt;
            if (cnt > 10000) {
                return false;
            }
        }
    }
}
