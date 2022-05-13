/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
    
        Queue<Node> prev = new LinkedList<>();
        prev.add(root);
        prev.add(null);
        while(prev.peek()!=null){
            
                Node out = prev.poll();           
                if(out.left!=null)prev.add(out.left);
                if(out.right!=null)prev.add(out.right);
                if(prev.peek()==null){
                    out.next = null;
                    prev.poll();
                    prev.add(null);
                }else out.next = prev.peek();
            
                
        }
        return root;
    }
}