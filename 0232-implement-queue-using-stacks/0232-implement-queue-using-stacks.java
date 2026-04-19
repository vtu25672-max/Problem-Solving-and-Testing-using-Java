import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    // Constructor
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from the front of queue and returns it
    public int pop() {
        // If s2 is empty, transfer all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Get the front element
    public int peek() {
        // If s2 is empty, transfer all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // --- For testing ---
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue: [1]
        myQueue.push(2); // queue: [1, 2]
        System.out.println(myQueue.peek());   // Output: 1
        System.out.println(myQueue.pop());    // Output: 1
        System.out.println(myQueue.empty());  // Output: false
    }
}
