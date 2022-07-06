// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;

class FastReader{ 
	BufferedReader br; 
	StringTokenizer st; 

	public FastReader(){ 
		br = new BufferedReader(new InputStreamReader(System.in)); 
	} 

	String next(){ 
		while (st == null || !st.hasMoreElements()){ 
			try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
		} 
		return st.nextToken(); 
	} 

	String nextLine(){ 
		String str = ""; 
		try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
		return str; 
	} 
} 

class Gfg
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            out.println(T.reduced_String(k, s));
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that 
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer, 
    which has O(1) complexity for each append.
*/

class Solution
{
     public static String reduced_String(int k, String s)
    {

        Stack<Pair> st = new Stack<>();
        int count = 1;
        int n = s.length();
        int idx = 0;
        st.push(new Pair(s.charAt(idx), count));
        idx++;
        while(idx<=n){
             if(count==k){
                    st.pop();
                    if (st.size()==0)count = 1;
                    else count = st.peek().count;
                }
                    if (idx==n)break;
            char ch1 = s.charAt(idx);
            if(st.size() != 0 && ch1 == st.peek().ch){
                count++;
                st.peek().count = count;
               
            }else{
                st.push(new Pair(ch1,1));
            }
            idx++;
            if (st.size()==0)count = 1;
            else count = st.peek().count;
        }

        if (st.size()==0)return "";

        StringBuilder str = new StringBuilder();

        while(st.size()!=0){
            for (int i = 0; i < st.peek().count; i++) {
                str.append(st.peek().ch);
            }
            
            st.pop();
        }

        return String.valueOf(str.reverse());



    }
}


class Pair{
    
    char ch;
    int count;
    
    Pair(char ch , int count){
        this.ch = ch;
        this.count = count;
    }
    
}