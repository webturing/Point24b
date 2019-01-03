package ajd.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ShuffleDemo {
    final static String[] ops = "+ - * /".split(" ");
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("shuffle demo");
        Vector<Integer> balls = new Vector<>();
        for (int i = 1; i <= 15; i++) {
            balls.add(i);
        }
        System.out.println(balls);
        Collections.shuffle(balls);
        System.out.println(balls.subList(0, 6));

        int a[] = {1, 5, 5, 5};


        int cnt = 0;
        while (true) {
            String exp[] = new String[7];
            for (int i = 0; i < 4; i++)
                exp[i] = String.valueOf(a[i]);
            exp[4] = ops[random.nextInt(4)];
            exp[5] = ops[random.nextInt(4)];
            exp[6] = ops[random.nextInt(4)];
            List<String> v = Arrays.asList(exp);//neat
            Collections.shuffle(v);
            ++cnt;
            if (cnt > 2000000) {
                System.out.println("No solution");
                break;
            }
            if (Tools.eval(v) == 24.0) {
                System.out.println(v);
                break;
            }
        }
    }
}
