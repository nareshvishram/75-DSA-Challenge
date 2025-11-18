class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        shuffle(st1, st2);
        int val = st2.pop();
        shuffle(st2, st1);
        return val;
    }

    public int peek() {
        shuffle(st1, st2);
        int val = st2.peek();
        shuffle(st2, st1);
        return val;
    }

    public boolean empty() {
        return st1.isEmpty();
    }

    private void shuffle(Stack<Integer> st1, Stack<Integer> st2) {
        while (!st1.isEmpty())
            st2.push(st1.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */