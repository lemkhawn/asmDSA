package Entity;

public class Queue {
    // current number of element
    int size;
    // capacity
    int max;
    // pointer for first and last
    int f, l;
    String[] queue;

    public Queue(int max) {
        this.max = max;
        queue = new String[this.max];
        size = 0;
        f = -1;
        l = -1;
    }

    public boolean isEmpty() {
        return (f == -1);
    }

    public boolean isFull() {
        return ((f == 0 && l == max - 1) || (l + 1 == f));
    }

    public boolean grow() {
        int newMax = max + max / 2;
        String[] newQ = new String[newMax];
        if (f <= l) {
            for (int i = f; i < l; i++) {
                newQ[i - f] = queue[i];
            }
        } else {
            for (int i = f; i < max; i++) {
                newQ[i - f] = queue[i];
            }
            for (int i = 0; i < l; i++) {
                newQ[max - f + i] = queue[i];
            }
        }

        int temp = 0;
        if (f <= l) {
            temp = l - f + 1;
        } else {
            temp = max - f + l + 1;
        }
        f = 0;
        l = temp - 1;
        max = newMax;
        queue = newQ;
        return true;
    }

    public String enqueue(String str) {
        if (isFull() && !grow()) {
            return null;
        }

        if (l == -1 || l == max - 1) {
            queue[0] = str;
            l = 0;
            if (f == -1) {
                f = 0;
            }
        } else {
            l = l + 1;
            queue[l] = str;
        }
        return str;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String str = queue[f];
        queue[f] = null;
        if (f == l) {
            f = l = -1;
        } else {
            if (f == max - 1) {
                f = 0;
            } else {
                f = f + 1;
            }
        }
        return str;
    }

    public void show() {
        String str = null;
        while ((str = dequeue()) != null) {
            System.out.println(str);
        }
    }

    public void sender(String str) {
        Queue queue = new Queue(50);
        queue.enqueue(str);
    }

}