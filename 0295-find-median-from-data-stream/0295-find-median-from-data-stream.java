class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left=new PriorityQueue<>((a,b)->b-a);
        this.right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty())
            left.add(num);
        else {
            if(left.peek()<=num)
                right.add(num);
            else
                left.add(num);
        }
        if(left.size()>right.size()+1)
            right.add(left.poll());
        else if(right.size()>left.size()+1)
            left.add(right.poll());
        //System.out.println(left+" "+right);  
    }
    
    public double findMedian() {
        int a=left.size();
        int b=right.size();
        if((a+b)%2==0)
            return (double)(left.peek()+right.peek())/2.0;
        if(a==0)
            return (double)right.peek();
        if(b==0)
            return (double)left.peek();
        if(a>b)
            return (double)Math.min(left.peek(),right.peek());
        return (double)Math.max(left.peek(),right.peek());
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */