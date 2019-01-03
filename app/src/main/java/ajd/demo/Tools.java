package ajd.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tools {
    public static void main(String[] args) {

        System.out.println(IsNumber("12.345"));
        System.out.println(IsNumber("sjkfjka"));
        String[] exp = "5 - 1 5 /   5 *".split("\\s+");

        System.out.println(eval(exp));
    }

    public static double eval(String[] exp) {
        return eval(Arrays.asList(exp));
    }

    public static double eval(List<String> exp) {
        Stack<Double> stack = new Stack<Double>();
        for (String s : exp) {
            if (IsNumber(s)) {
                stack.push(Double.parseDouble(s));
            } else if ("+-*/".contains(s)) {
                if (stack.isEmpty()) return -1;//出错
                double b = stack.pop();
                double a = 0;
                try {
                    a = stack.pop();
                } catch (Exception e) {
                    return -1;
                }
                double result = 0;
                switch (s) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.peek();
    }

    private static boolean IsNumber(String s) {
        try {
            double t = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
