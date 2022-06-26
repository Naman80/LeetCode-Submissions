class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
     
        int sum = 0;
        for(int i :card)sum+=i;
        int presum = 0;
        int i;
        for(i = 0 ; i < n - k ; i++){
            presum +=card[i];
        }
        int j = i;
        i = 0;
        int leftsum = sum - presum;
        
        int max = leftsum;
        
        while(j<n){
            
            leftsum-=card[j];
            leftsum+=card[i];i++;j++;
            max = Math.max(max,leftsum);
        }
        
        return max;
        
    }
}