package data.model.graphique;
import java.util.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Point;

public class Graph {
    private String label;
    private ArrayList<Node> nodes;

    public Graph(){
      this("", new ArrayList<Node>());
    }
    public Graph(String aLabel){
      this(aLabel, new ArrayList<Node>());
    }
    public Graph(String aLabel, ArrayList<Node> initialNodes){
        label = aLabel;
        nodes = initialNodes;
    }
    public ArrayList<Node> getNodes(){
      return nodes;
    }
    public String getLabel(){
      return label;
    }
    // Get all the edges of the graph by asking the nodes for them
    public ArrayList<Edge> getEdges() {
        ArrayList<Edge>  edges = new ArrayList<Edge>();
        for (Node n: nodes) {
            for (Edge e: n.incidentEdges()) {
                if (!edges.contains(e)) //so that it is not added twice
                    edges.add(e);
            }
        }
      return edges;
    }
    public void setLabel(String newLabel){
      label = newLabel;
    }
    public void addNode(Node aNode){
      nodes.add(aNode);
    }
    public void addEdge(Node start, Node end) {
        // First make the edge
        Edge anEdge = new Edge(start, end);

        // Now tell the nodes about the edge
        start.addIncidentEdge(anEdge);
        end.addIncidentEdge(anEdge);
    }
    public void deleteEdge(Edge anEdge){
      // Just ask the nodes to remove it
      anEdge.getStartNode().incidentEdges().remove(anEdge);
      anEdge.getEndNode().incidentEdges().remove(anEdge);
    }
    public void addEdge(String startLabel, String endLabel) {
        Node start = this.nodeNamed(startLabel);
        Node end = this.nodeNamed(endLabel);

        if ((start != null) && (end != null)){
        System.out.println(start+""+end);
            this.addEdge(start, end);}
        else{this.addEdge(new Node(), new Node());}
    }


    public void deleteNode(Node aNode) {
        // Remove the opposite node's incident edges
        for (Edge e:   aNode.incidentEdges())
            e.otherEndFrom(aNode).incidentEdges().remove(e);
        nodes.remove(aNode);  // Remove the node now
    }
    public Node nodeNamed(String aLabel) {
        for (Node n:  nodes)
            if (n.getLabel().equals(aLabel))
              return n;
        return null;  // If we don't find one
    }

    // Graphs look like this: label(6 nodes, 15 edges)
    public String toString(){
        return(label + "(" + nodes.size() + " nodes, " +
               getEdges().size() + " edges)");
    }
    public static Graph exemple(){

      Graph myMap = new Graph("test");
      myMap.addNode(new Node("Ottawa", new Point(250,100)));
      myMap.addNode(new Node("Toronto", new Point(100,120)));
      myMap.addNode(new Node("Kingston", new Point(200,130)));
      myMap.addNode(new Node("Montreal", new Point(300,70)));
      myMap.addEdge("Ottawa", "Toronto");
      myMap.addEdge("Ottawa", "Montreal");
      myMap.addEdge("Ottawa", "Kingston");
      myMap.addEdge("Kingston", "Toronto");
      return myMap;
    }

    public void draw(Graphics aPen) {
        ArrayList<Edge>    edges = getEdges();

        for (Edge e: edges)  // Draw the edges first
            e.draw(aPen);
        for (Node n: nodes)   // Draw the nodes second
            n.draw(aPen);
    }
}
