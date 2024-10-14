package LGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> graphHash = new HashMap<>();

    public boolean addVertex(String vertex){
        if(!graphHash.containsKey(vertex)){
            graphHash.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }
    public boolean addEdge(String vertex1, String vertex2){
        if(graphHash.containsKey(vertex1) && graphHash.containsKey(vertex2)){
            graphHash.get(vertex1).add(vertex2);
            graphHash.get(vertex2).add(vertex1);
            return  true;
        }
        return  false;
    }

    public boolean removeVertex(String vertex){
        if(graphHash.containsKey(vertex)){
            for(String otherVertex: graphHash.get(vertex)){
                graphHash.get(otherVertex).remove(vertex);
            }
            graphHash.remove(vertex);
            return true;
        }
        return false;
    }
    public boolean removeEdge(String vertex1, String vertex2){
        if(graphHash.containsKey(vertex1) && graphHash.containsKey(vertex2)){
            graphHash.get(vertex1).remove(vertex2);
            graphHash.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }
    public void printGraph(){
        System.out.println(graphHash);
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");
        myGraph.removeEdge("A", "C");
        myGraph.removeVertex("B");
        myGraph.printGraph();

    }
}
