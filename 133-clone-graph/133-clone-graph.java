/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Node start = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        Queue<Node> sq = new LinkedList<>();
        sq.add(start);
        q.add(node);
        HashMap<Integer,Node> hm = new HashMap<>();
        // hs.add(node.val);
        while(!q.isEmpty()){
            
            Node out = q.poll();
            Node outsq = sq.poll();
            hm.put(out.val , outsq);
            for(Node x : out.neighbors){
                if(!hm.containsKey(x.val)){
                    Node temp = new Node(x.val);
                    outsq.neighbors.add(temp);
                    hm.put(x.val , temp);
                    q.add(x);
                    sq.add(temp);
                }else{
                    outsq.neighbors.add(hm.get(x.val));
                }
                // System.out.print(temp.val + " ");
               
            }
            
        }
        // System.out.println(hm);
        // System.out.print(start);
        
        return start;
    }
}