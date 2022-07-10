class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> hs;
    public SmallestInfiniteSet() {
        
        pq = new PriorityQueue<>();
        hs = new HashSet<>();
        
        for(int i = 1;i<1001;i++){
            pq.add(i);
            hs.add(i);
        }
        
    }
    
    public int popSmallest() {
        int in = pq.poll();
        hs.remove(in);
        return in;
    }
    
    public void addBack(int num) {
        
        if(!hs.contains(num)){
            pq.add(num);
        }
        hs.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */