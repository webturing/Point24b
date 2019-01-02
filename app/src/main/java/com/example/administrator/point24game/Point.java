package com.example.administrator.point24game;

import android.widget.Toast;

import java.util.Vector;

class Tree{
    char op;
    int value;
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
        }
        if(op == '*' || op == '/'){
            if(right.op == '+' || right.op == '-'){
                right.s = String.format("(%s)",right.s);
            }
        }
        this.s = String .format("%s%c%s",left.s, op, right.s);
    }
    public Tree(int value){
        this.op = '\0';
        this.value = value;
        this.s = String.valueOf(value);
        this.left = null;
        this.right = null;
    }
    public Tree(char op, int left, int right) {
        this.op = op;
        this.left = new Tree(left);
        this.right = new Tree(right);
        this.value = op(left, op, right);
        this.s = String.format("%d%c%d",left, op, right);
    }

    private int op(int left, char op, int right) {
        if(op == '+'){
            return left + right;
        }
        else if(op == '-'){
            return left - right;
        }
        else if(op == '*'){
            return left * right;
        }else{
            if (right==0)return Integer.MIN_VALUE;
            return left / right;
        }
    }

    public Tree() {
    }
}
public class Point {
    int a, b, c, d;
    char[]out = new char[3];
    char[] ops = "+-*/".toCharArray();
    Vector<String>results = new Vector<>();

    public Point(int a, int b, int c, int d) {
        this.a = a; this.b = b; this.c = c; this.d = d;

        for(int i = 1; i <= 3; i++){
            dfs(i,0);
        }
    }

    private void dfs(int type, int step) {
        if(step >= 3){
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
        if(root.value == VALUE){
            results.add(root.s);
        }
    }

    final int VALUE = 24;
    public String getResult(){
        if (results.size() <= 0){
            return "无解";
        }else{
            int random = ((int)(Math.random()*results.size()))%results.size();
            return results.get(random);
        }
    }

}
