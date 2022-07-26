// LETS CREATE SEGMENT TREE OF THIS ARRAY
// SPLIT APPRY AT ALL INDEXES
// CREATE NEW SEGMENT TREE ARRAY OF SIZE (4N)  <-- MAX SIZE
// LOW HIGH POS <-- PARAMETERS WHILE CREATE ST




// 107549


class NumArray {
    int[] segtree;
    int n;
    public int createSegTree(int low , int high , int pos , int[] nums){
        if(low == high){
            return segtree[pos] = nums[low];
        }
        int mid = low + (high - low)/2;
        int left = createSegTree(low , mid , 2*pos+1 ,nums);
        int right = createSegTree(mid+1 , high , 2*pos+2,nums);
        return segtree[pos] = left + right;   
    }
    public int querySum(int ql , int qr , int low , int high , int pos){
        if(ql <= low && high <= qr)return segtree[pos];
        if(high < ql ||  qr < low)return 0;
        int mid = low + (high - low)/2;
        int left = querySum( ql , qr , low , mid , 2*pos+1);
        int right = querySum( ql , qr , mid+1 , high , 2*pos+2);
        return  left + right;   
    } 
    public NumArray(int[] nums) {
        n = nums.length;
        segtree = new int[4*n];
        createSegTree(0,n-1,0,nums);
        // for(int i= 0 ; i < segtree.length ; i++){
            // System.out.print(segtree[i] + " ");
        // }
    }
    public int sumRange(int left, int right) {
        return querySum(left , right , 0 , n-1 , 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */