package com.example.administrator.point24game;

import java.util.Arrays;
import java.util.Vector;

class Tree{
    char op;
    double value;
    String s;
    Tree left, right;

    public Tree(char op, Tree left, Tree right) {
        this.op = op;
        this.left = left;
        this.right = right;
        this.value = op(left.value,op, right.value);
        if(op == '*' || op == '/'){
            if(left.op == '+' || left.op == '-'){
                left.s = String.format("(%s)",left.s);
            }
            if(right.op == '+' || right.op == '-'){
                right.s = String.format("(%s)",right.s);
            }
        }
        if (op == '/' && (right.op == '/' || right.op == '*')){
            right.s = String.format("(%s)",right.s);
        }
        if (op == '-' && (right.op == '-' || right.op == '+')){
            right.s = String.format("(%s)",right.s);
        }
        this.s = String .format("%s%c%s",left.s, op, right.s);
    }
    public Tree(double value){
        this.op = '\0';
        this.value = value;
        this.s = String.format("%.0f",value);
        this.left = null;
        this.right = null;
    }
    public Tree(char op, double left, double right) {
        this.op = op;
        this.left = new Tree(left);
        this.right = new Tree(right);
        this.value = op(left, op, right);
        this.s = String.format("%.0f%c%.0f",left, op, right);
    }

    private double op(double left, char op, double right) {
        if(op == '+'){
            return left + right;
        }
        else if(op == '-'){
            return left - right;
        }
        else if(op == '*'){
            return left * right;
        }else{
            if (right==0)return Double.MAX_VALUE;
            return left / right;
        }
    }

    public Tree() {
    }
}
public class Point {
    double []arr, num = new double[4];
    char[]out = new char[3];
    int []book = new int[4];
    char[] ops = "+-*/".toCharArray();
    Vector<String>results = new Vector<>();

    public Point(double a, double b, double c, double d) {
        arr = new double[]{a, b, c, d};
        dfs2(0);
    }

    private void dfs2(int step) {
        if(step >= 4){//四个数字的全排列
            for(int i = 1; i <= 3; i++){
                dfs(i,0);
            }
            return;
        }
        for (int i = 0; i < 4; i++){
            if(book[i] == 0){
                book[i] = 1;
                num[step] = arr[i];
                dfs2(step+1);
                book[i] = 0;
            }
        }
    }

    private void dfs(int type, int step) {
        if(step >= 3){
            double a = num[0], b = num[1], c = num[2], d = num[3];
            System.err.println(Arrays.toString(num));
            Tree root;
            if(type == 1){
                Tree left = new Tree(out[0], a, b);
                Tree right = new Tree(out[1], c, d);
                root = new Tree(out[2], left, right);
            }else if(type == 2){
                Tree left = new Tree(a);
                Tree right = new Tree(out[1], new Tree(out[0],b, c),new Tree(d));
                root = new Tree(out[2], left, right);
            }else{
                Tree left = new Tree(a);
                Tree right = new Tree(out[1], new Tree(b), new Tree(out[0], c, d));
                root  = new Tree(out[2], left, right);
            }
            getLastFix(root);
            return;
        }
        for(int i = 0; i < 4; i++){
            out[step] = ops[i];
            dfs(type, step+1);
        }
    }
    private void getLastFix(Tree root){
        if(Math.abs(root.value - VALUE) < 1e-5){
            results.add(root.s);
        }
    }

    final double VALUE = 24;
    public String getResult(){
        if (results.size() <= 0){
            return "无解";
        }else{
            int random = ((int)(Math.random()*results.size()))%results.size();
            return results.get(random);
//            String ret = "";
//            for (String s:results
//                 ) {
//                ret += s+"<br>";
//            }
//            return ret;//全部打印
        }
    }

}
