package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = generateGraphWithNodes();
        findPath(graph, 66, 42);
    }

    public static Graph generateGraphWithNodes() {
        Graph g = new Graph();
        g.generateNodes(66);
        int[][] edges = { {1,2}, {1,9}, {2,1}, {2,3}, {2,10}, {3,2}, {3,4}, {3,11}, {4,3}, {4,5}, {5,4}, {5,6}, {5,8}, {6,5}, {6,15}, {7,4}, {7,8}, {7,12}, {8,5}, {8,7}, {8,13}, {9,1}, {9,16}, {10,2}, {10,9}, {10,17}, {11,3}, {11,10}, {11,18}, {12,7}, {12,11}, {13,8}, {13,12}, {13,21}, {14,13}, {14,22}, {15,6}, {15,14}, {15,23}, {16,9}, {16,24}, {17,10}, {17,16}, {17,25}, {18,11}, {18,19}, {18,26}, {19,18}, {19,20}, {19,28}, {20,19}, {20,21}, {21,13}, {21,20}, {21,22}, {21,30}, {22,14}, {22,21}, {22,23}, {23,15}, {23,22}, {23,31}, {24,16}, {24,25}, {24,35}, {25,17}, {25,26}, {25,37}, {26,18}, {26,27}, {27,28}, {27,33}, {28,19}, {28,29}, {29,20}, {29,30}, {30,21}, {30,31}, {30,34}, {31,23}, {31,41}, {32,26}, {33,27}, {33,34}, {33,39}, {34,30}, {34,33}, {34,40}, {35,24}, {35,36}, {35,48}, {36,35}, {36,37}, {36,42}, {37,25}, {37,36}, {37,38}, {37,44}, {38,32}, {38,37}, {38,39}, {39,33}, {39,38}, {39,40}, {40,34}, {40,39}, {40,41}, {40,47}, {41,31}, {41,40}, {41,55}, {42,36}, {42,43}, {43,42}, {43,44}, {43,49}, {44,37}, {44,43}, {44,45}, {44,50}, {45,44}, {45,51}, {46,45}, {46,52}, {47,40}, {47,46}, {47,53}, {48,35}, {48,56}, {49,43}, {49,48}, {50,44}, {50,49}, {50,57}, {51,45}, {51,50}, {51,58}, {52,46}, {52,51}, {53,47}, {53,52}, {53,59}, {54,53}, {55,41}, {55,54}, {55,62}, {56,48}, {56,57}, {57,50}, {57,58}, {58,51}, {58,59}, {59,53}, {59,60}, {59,63}, {60,61}, {60,64}, {61,62}, {61,65}, {62,55}, {62,66}, {63,59}, {63,64}, {64,60}, {64,63}, {64,65}, {65,64}, {65,66}, {66,62}, {66,65} };
        for (int[] e : edges) g.connectNodes(e[0], e[1]);
        return g;
    }

    public static void findPath(Graph g, int idA, int idB) {
        Node start = g.getNode(idA);
        Node end = g.getNode(idB);
        List<Integer> path = new ArrayList();
        path = bfs(g, start, end);
        output(path, start, end);
    }

    public static void output(List<Integer> path, Node start, Node end) {
        String output = String.format("Path from %d to %d: %s", start.getId(), end.getId(), path);
        System.out.println(output);
    }

    // Modified breadth-first search
    public static List<Integer> bfs(Graph g, Node start, Node end)  {
        boolean[] visited = new boolean[g.getNodes().size()];
        Queue<Node> q = new LinkedList();
        int[] map = new int[g.getNodes().size()];
        for (int i = 0; i < map.length; i++) map[i] = -1;
  
        visited[start.getId()-1] = true;
        q.add(start);
  
        // BFS
        while (!q.isEmpty()) { 
            Node n = q.remove(); 
            for (Node c : n.getNodes()) { 
                if (visited[c.getId()-1] == false) { 
                    visited[c.getId()-1] = true;
                    map[c.getId()-1] = n.getId()-1; // Link to predecessor
                    q.add(c);
  
                    if (c == end) break;
                } 
            } 
        }

        // Process map into list
        List<Integer> path = new ArrayList(); 
        int crawl = end.getId()-1; 
        path.add(crawl+1);
        while (map[crawl] != -1) { 
            path.add(map[crawl]+1); 
            crawl = map[crawl]; 
        }
        Collections.reverse(path);

        return path;
    } 
}
