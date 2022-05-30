// { Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}



// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
       Node mid = findMid(head);
       
       Node rev = reverse(mid.next);
       
       mid.next = rev;
       mid = mid.next;
       Node temp = head;
       while(mid!=null){
           if(mid.data != temp.data) return false;
           mid = mid.next;
           temp = temp.next;
       }
       
       return true;
      
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        
        while(curr!=null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    Node findMid(Node head){
        // int count = 0 ;
        // Node temp = head;
        // while(temp!=null){
        //     count++;
        //     temp = temp.next;
        // }
        // int mid ;
        // if(count %2==0) mid = (count/2 )- 1;
        // else mid = count /2;
        // temp = head;
        // for(int i = 0 ; i < mid ; i++){
        //     temp = temp.next;
        // }
        // return temp;
        
        Node slow = head;
        Node fast = head.next;
        
        while(fast!=null  && fast.next !=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        return slow;
        
    }
}

