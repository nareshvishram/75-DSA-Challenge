class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty())
            left.add(num);
        else {
            if (left.peek() <= num)
                right.add(num);
            else
                left.add(num);
        }
        if (right.size() - left.size() > 1)
            left.add(right.poll());
        else if (left.size() - right.size() > 1)
            right.add(left.poll());
    }

    public double findMedian() {
        int n1 = left.size(), n2 = right.size();
        if ((n1 + n2) % 2 == 0)
            return (double) (left.peek() + right.peek()) / 2.0;
        if (n1 == 0)
            return right.peek();
        if (n2 == 0)
            return left.peek();
        if (n1 > n2)
            return (double) Math.min(left.peek(), right.peek());
        return (double) Math.max(left.peek(), right.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */