class MedianFinder {
ArrayList<Integer> al;
    public MedianFinder() {
        al = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int x  = Collections.binarySearch(al , num);
        int pos = Math.abs(x+1);
        al.add( pos,num);  
        
   
    }
    
    public double findMedian() {
        int n = al.size();
        if(n%2==1){
            return (double)(al.get(n/2));
        }else{
            double mid = (double)al.get(n/2) + (double)al.get((n/2)-1);
            return mid/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */