package ajd.demo;

import java.util.Arrays;
import java.util.List;

public class Permutation {
    /**
     * 逆康拓展开，根据数值直接生成排列
     *
     * @param x 数值
     * @param m 长度
     * @return
     */
    public static int[] codel(int x, int m) {
        int[] label = new int[m];
        int[] n = new int[m];
        int cnt;
        for (int i = 0; i < m; i++) label[i] = 1;
        for (int i = 0; i < m; i++) {
            cnt = x / BruteSearcher.FAC[m - 1 - i];
            x = x % BruteSearcher.FAC[m - 1 - i];
            for (int j = 0; j < m; j++) {
                if (label[j] == 0) continue;
                if (cnt == 0) {
                    label[j] = 0;
                    n[i] = j;
                    break;
                }
                cnt--;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        for (int c = 0; c < BruteSearcher.FAC[4]; c++) {
            System.out.println(Arrays.toString(codel(c, 4)));
        }
    }
}