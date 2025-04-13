import java.util.ArrayList;
import java.util.HashMap;
class Node{
    int val;
    ArrayList<Node> neighbors;
    public Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
class Solution {
    Node cloneGraph(Node node) {
        HashMap<Node,Node> isVisited=new HashMap<>();
        return helper(node,isVisited);
    }
    private Node helper(Node node,HashMap<Node,Node> isVisited){
        if(isVisited.containsKey(node)) return isVisited.get(node);
        Node tempNode=new Node(node.val);
        isVisited.put(node,tempNode);
        for(Node neighbor:node.neighbors){
            tempNode.neighbors.add(helper(neighbor,isVisited));
        } 
        return tempNode;
    }
}