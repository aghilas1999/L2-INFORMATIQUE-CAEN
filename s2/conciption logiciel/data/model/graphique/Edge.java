package data.model.graphique;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Edge  {
    private String   label;
    private Node     startNode, endNode;

    public Edge(Node start, Node end){
      this("", start, end);
    }
    public Edge(String aLabel, Node start, Node end){
        label = aLabel;
        startNode = start;
        endNode = end;
    }

    public String getLabel(){
      return label;
    }
    public Node getStartNode(){
      return startNode;
    }
    public Node getEndNode(){
      return endNode;
    }

    public void setLabel(String newLabel){
      label = newLabel; }
    public void setStartNode(Node aNode){
      startNode = aNode;
    }
    public void setEndNode(Node aNode){
      endNode = aNode;
    }

    // les liens ressemblent à ça: sNode(12,43) --> eNode(67,34)
    public String toString() {
        return(startNode.toString() + " --> " + endNode.toString());
    }

    public Node otherEndFrom(Node aNode){
      if (startNode == aNode)
          return endNode;
      else
          return startNode;
      }

      public void draw(Graphics aPen) {
          // Dessine un lien noir
          aPen.setColor(Color.black);
          aPen.drawLine(startNode.getLocation().x, startNode.getLocation().y,
                        endNode.getLocation().x, endNode.getLocation().y);
      }


}
