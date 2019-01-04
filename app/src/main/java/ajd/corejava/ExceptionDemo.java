package ajd.corejava;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.out.println("I catch you!");
        }
        System.out.println("hello exception");
        int a[] = {1, 2, 3};
        try {
            System.out.println(a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            int b[] = new int[a.length * 2];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            a = b;
            System.out.println(a[3]);

        }
        a[4] = -7;
        System.out.println(Math.sqrt(a[4]));

    }
}
