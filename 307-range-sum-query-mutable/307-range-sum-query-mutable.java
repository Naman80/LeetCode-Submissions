class NumArray {
    int[]segTree;
    int n;
    
    public void buildST(int[] nums, int low , int high , int pos){
        if(low == high){
            segTree[pos] = nums[low];
            return ;
        }
        int mid  = low + (high - low)/2;
        buildST(nums , low , mid , 2*pos +1);
        buildST(nums , mid+1, high , 2*pos +2);
        segTree[pos] = segTree[2 * pos + 1]  + segTree[2*pos+2];
    }
    
    
    public int query( int ql , int qh , int low ,int high , int pos){
        if(ql <= low && high <= qh)return segTree[pos];
        if(high < ql ||  low  > qh)return 0;
        int mid = low + (high - low)/2;
        int left = query( ql , qh , low , mid,2*pos+1);
        int right = query( ql,qh , mid+1,high , 2*pos+2);
        return left  + right;
    }
    
    public void change(int low  , int high , int pos , int idx, int val ){
        
        if(low==high){
            segTree[pos] = val;
            return ;
        }
        int mid = low + (high - low)/2;
        if(idx <= mid)change(low, mid, 2*pos +1,idx,val);
        else change(mid+1, high , 2*pos+2,idx,val);
        segTree[pos] = segTree[2 * pos + 1]  + segTree[2*pos+2];
    }
    
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildST(nums, 0 , n - 1, 0 );
    }
    
    public void update(int index, int val) {
        
        change(0,n-1,0,index,val);
        
        
    }
    
    public int sumRange(int left, int right) {
        
        return query( left , right , 0  , n -1 ,0);        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */