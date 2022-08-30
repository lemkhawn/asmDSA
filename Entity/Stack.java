package Entity;

public class Stack {
    private int max,top;
    String[] stack;
    
    public Stack(int max) {
        this.max = max;
        stack = new String[this.max];
        top = -1;
    }
    
    public boolean grow() {
        int newMax = max + max / 4;
        String[] newStack = new String[newMax];
        for(int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }
        max = newMax;
        stack = newStack;
        return true;
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == max - 1);
    }
    
    public String push(String str) {
        if(isFull() && !grow()) {
            return null;
        } else {
            stack[++top] = str;
        }
        return str;
    }
    
    
    public String pop() {
        if(isEmpty()) {
            return null;
        }
        String str = stack[top];
        stack[top] = null;
        top = top - 1;
        return str;
    }
    
    public String top() {
        if(isEmpty()) {
            return null;
        }
        String str = stack[top];
        return str;
    }
    
    public void show() {
        String str = null;
        while((str = pop()) != null) {
            System.out.println(str);
        }
    }
    
    public static int sum(int a, int b) {
        return a + b;
    }
    
}