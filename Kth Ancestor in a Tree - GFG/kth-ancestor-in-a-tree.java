// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String arr[] = br.readLine().split(" ");
	            int k = Integer.parseInt(arr[0]);
	            int node = Integer.parseInt(arr[1]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
        		System.out.println(g.kthAncestor(root,k,node));
                    t--;
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Tree
{
    public int kthAncestor(Node root, int k, int node)
    {
        ArrayList<Integer> path = new ArrayList<>();
        rtnp(root,node,path);
        Collections.reverse(path);
        if(k>= path.size())return -1;
        return path.get(k);
    }
    
    void rtnp(Node root,int node,ArrayList<Integer> path){
        
    if(root==null)return;
        if(root.data==node){
            path.add(node);return;
        }
    rtnp(root.left,node,path);
        if(path.size() != 0){
            path.add(0,root.data);
            return ;
        }
    rtnp(root.right,node,path);
        if(path.size() != 0){
            path.add(0,root.data);
            return;
        }
    }
}