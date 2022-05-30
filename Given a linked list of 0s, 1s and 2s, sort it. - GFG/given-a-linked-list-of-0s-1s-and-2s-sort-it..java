// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        
        Node Dummy1 = new Node(-1);
        Node temp1 = Dummy1;
        Node Dummy2 = new Node(-1);
        Node temp2 = Dummy2;
        Node Dummy3 = new Node(-1);
        Node temp3 = Dummy3;
        Node temp = head;
        
        while(temp!=null){
            
            if(temp.data == 0){
                temp1.next = temp;
                temp1 = temp;
            }else if(temp.data == 1){
                temp2.next = temp;
                temp2 = temp;
            }else{
                temp3.next = temp;
                temp3 = temp;
            }
            
            temp = temp.next;
            
        }
        
        temp3.next = null;
        temp2.next = Dummy3.next;
        temp1.next = Dummy2.next;
        
        
        return Dummy1.next;
    }
}


