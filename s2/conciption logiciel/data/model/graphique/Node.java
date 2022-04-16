package data.model.graphique;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;


public class Node{
    private String label;
    private Point location;
    private ArrayList<Edge> incidentEdges = new ArrayList<Edge>();


    //Constructeurs, plusieurs arguments possibles, surcharge de la methode
      public Node(){
         this("",new Point(0,0));
      }
      public Node(String aLabel){ //Legende du noeud
        this(aLabel, new Point(0,0));
      }
      public Node(Point aPoint){ //coord du point/noeud
         this("", aPoint);
       }
      public Node(String aLabel, Point aPoint){
          label = aLabel;
          location = aPoint;
      }
    //getter
      public ArrayList<Edge> incidentEdges(){
        return incidentEdges;
      }
      public String getLabel(){
        return label;
      }
      public Point getLocation(){
        return location;
      }
      public void addIncidentEdge(Edge e){
                        System.out.println(e);
                        System.out.println(incidentEdges);
        this.incidentEdges.add(e);
      }
      //setter
      public void setLabel(String newLabel) {
        label = newLabel;
      }
      public void setLocation(Point aPoint) {
        location = aPoint;
      }
      public void setLocation(int x, int y) {
        location = new Point(x, y);
      }

    // Retourner les coord du noeud
    public String toString() {
        return(label + "(" + location.x + "," + location.y + ")");
    }
    //retourne le noeud qui est connecté au noeud receveur par un edge
    public ArrayList<Node> neighbours() {
      ArrayList<Node> result = new ArrayList<Node>();
      for (Edge e: incidentEdges)
          result.add(e.otherEndFrom(this));
      return result;
    }

    public void draw(Graphics aPen) {
        int    radius = 15;

        // Dessine un rond bleu autour du noeud
        aPen.setColor(Color.blue);
        aPen.fillOval(location.x - radius, location.y - radius, radius * 2, radius * 2);

        // dessine un rond noir pour faire la bordure du noeud
        aPen.setColor(Color.black);
        aPen.drawOval(location.x - radius, location.y - radius, radius * 2, radius * 2);

        // dessine la legende du noeud dans son coin
        aPen.drawString(label, location.x + radius, location.y - radius);
}

}
