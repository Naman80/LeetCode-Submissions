class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int mid = 0;
        
        while(i<=j){
        mid = i + (j-i)/2 ;
            
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) return mid;
            
            if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]){
                j = mid-1;
            }else{
                i   = mid+1;
            }
            
        }
        
        return 0;
       
    }
}