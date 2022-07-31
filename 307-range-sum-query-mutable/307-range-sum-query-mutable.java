class NumArray {
    
    int[] segtree;
    int n;
    void build(int low, int high , int pos , int[] nums){
        
        if(low == high){
            segtree[pos] = nums[low];
            return ;
        }
        int left = 2 *pos+1;
        int right = 2*pos+2;
        int mid = low + (high - low)/2;
        build(low , mid , left ,nums);
        build(mid+1,high , right , nums);
        segtree[pos] = segtree[left] + segtree[right];  
    }
    
    int query(int low , int high , int pos , int  l ,int r){
        if(high < l || low > r)return 0;
        if(l <= low && high <= r)return segtree[pos];
        int left = 2 *pos+1;
        int right = 2*pos+2;
        int mid = low + (high - low)/2;
        int ln = query(low, mid , left , l ,r);
        int rn = query(mid+1,high,right , l,r);
        return ln+rn;
    }
    
    
    void change(int low, int high , int pos , int idx , int val){
    
        if(low == high){
            segtree[pos] = val;
            return;
        }
        
        int left = 2 *pos+1;
        int right = 2*pos+2;
        int mid = low + (high - low)/2;
        
        if(mid>=idx){
            change(low , mid , left , idx,val);
        }else change(mid+1 , high , right, idx ,val);
        
        segtree[pos] = segtree[left] + segtree[right];  

        
        
        
    }
    

    public NumArray(int[] nums) {
        int N = nums.length;
        n = N;
        segtree = new int[4*N];
        build(0,n-1,0,nums);
        
    }
    
    public void update(int index, int val) {
        change(0 , n-1, 0 , index,val);
    }
    
    public int sumRange(int left, int right) {
        
        
        return query(0,n-1,0,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */