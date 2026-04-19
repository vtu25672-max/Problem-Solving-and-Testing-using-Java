import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        // Step 1: Add new element to q2
        q2.add(x);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        return q1.remove();
    }

    // Get the top element
    public int top() {
        return q1.peek();
    }

    // Returns whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }

    // --- For testing ---
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());    // Output: 2
        System.out.println(myStack.pop());    // Output: 2
        System.out.println(myStack.empty());  // Output: false
    }
}
