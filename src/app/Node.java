package app;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> nodes;
    private int id;

    public Node(int id) {
        this.nodes = new ArrayList();
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void addNode(Node n) {
        this.nodes.add(n);
    }

    public void printChildren() {
        String s = "";
        for (Node c : this.nodes) s += c.getId() + ",";
        System.out.println(s.substring(0, s.length()-1));
    }
}
