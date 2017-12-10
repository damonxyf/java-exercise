import java.util.Stack;



public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your Stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }



    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your Stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
       MyStack1 stack1 = new MyStack1();
        int n = (int) (Math.random() * 1000);
        int[] a = new int[n];

        int i;
        for (i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 1000);
            stack1.push(a[i]);
        }

        System.out.println(stack1);



    }
}