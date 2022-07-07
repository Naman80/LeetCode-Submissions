class Solution {
    
    //BINARY EXPONENTIATION
    
    // RECURSIVE CODE - COMPUTE A TO POWER B IN LOG(B) TIME 
//     public double myPow(double x, int n) {
//         if(n==0)return (double)1;
//         double temp = myPow(x,n/2);
//         double result = temp * temp;
//         if(n%2==1)result*=x;
//         return result;
//     }
    
     public double myPow(double x, int n) {
     
         return Math.pow(x,n);
     
     }
    
    //ITERATIVE CODE - FASTER
    // public int pow(int a , int b){
    //     int result = 1;   
    //     while(b>0){
    //         if(b%2==1)result *=a;
    //         a*=a;
    //         b/=2;
    //     }
    //     return result;
    // }
}