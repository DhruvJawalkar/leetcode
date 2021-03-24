class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap, minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {        
        if(maxHeap.isEmpty() || num<maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        if(Math.abs(maxHeap.size() - minHeap.size())>1){
            if(minHeap.size()>maxHeap.size())
                maxHeap.add(minHeap.poll());
            else
                minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */