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
        q.add(node);
        HashMap<Integer,Node> hm = new HashMap<>();
        hm.put(1 , start);
        while(!q.isEmpty()){ 
            Node out = q.poll();
            for(Node x : out.neighbors){
                if(!hm.containsKey(x.val)){
                    Node temp = new Node(x.val);
                    hm.get(out.val).neighbors.add(temp);
                    hm.put(x.val , temp);
                    q.add(x);
                }else{
                    hm.get(out.val).neighbors.add(hm.get(x.val));
                }
            }
        }
        return start;
    }
}