class Solution {
    public String pushDominoes(String s) {
        
        Stack<pair> st = new Stack<>();
        int n = s.length();
        char[] arr = new char[n];
        // st.push(new pair(s.charAt(n-1) , 0 , n-1));
        
        for(int i = n-1 ; i >=0 ; i--){
            
            char ch = s.charAt(i);
            
            if(ch == 'R'){
                if(st.size()==0){
                    arr[i] = 'R';
                    continue;
                }
                // System.out.println("andika");
                arr[i] = 'R';
                pair out = st.peek();
                
                boolean bal = false;
                if(out.lev%2!=0){
                    bal = true;
                }
                int half = out.lev /2;
             if(out.ch=='L'){  
                 while( half-- > 0){
                    arr[st.peek().idx] = 'R';
                    st.pop();
                }
                if(bal){
                    arr[st.peek().idx] = '.';
                    st.pop();
                }
                while(st.size()!=0){
                    arr[st.peek().idx] = 'L';
                    st.pop();
                }}
                
                
                while(st.size()!= 0 && st.peek().ch == '.'){
                    arr[st.peek().idx] = 'R';
                    st.pop();
                }
                
            }else if(ch == 'L'){    
                arr[i] = 'L';
                while(st.size()!=0){
                    pair out = st.pop();
                    arr[out.idx] = out.ch;
                }
             st.push(new pair('L' , 0 , i));
                
            }else{
                
                if(st.size()!=0 && st.peek().ch == 'L'){
                    st.push(new pair('L' , st.peek().lev +1 , i));
                }else{
                    st.push(new pair('.' , 0 , i));
                }
                
                
            }
            
        }
        
        while(st.size()!=0){
            arr[st.peek().idx] = st.peek().ch;
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            sb.append(arr[i]);
        }
        
        return String.valueOf(sb);
    
    
    
    
    
    }
}

class pair{
    
    char ch;
    int lev;
    int idx;
    
    pair(char ch , int lev , int idx){
        this.ch = ch;
        this.lev = lev ;
        this.idx = idx;
    }
}



// "RR.L"
// ".L.R...LR..L.."
// "LLLRRR"
// "R....."
// "L......"
// "......"
// "LLLLLL"
// "RRRRRRR"
// "....L"
// ".....R"