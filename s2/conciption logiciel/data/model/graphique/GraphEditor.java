package data.model.graphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GraphEditor extends JPanel implements MouseListener{
    private Graph  aGraph;  // The model (i.e. the graph)

    public GraphEditor() { this(new Graph()); }
    public GraphEditor(Graph g) {
        aGraph = g;
        setBackground(Color.white);
        aGraph.exemple();
    }
    public void addEventHandlers() {
      addMouseListener(this);
    }
    public void removeEventHandlers() {
      removeMouseListener(this);
    }

    // This is the method that is responsible for displaying the graph
    public void paintComponent(Graphics aPen) {
        super.paintComponent(aPen);
        aGraph.draw(aPen);
    }
    public void mouseClicked(MouseEvent event) {
      // If this was a double-click, then add a node at the mouse location
      /*if (event.getClickCount() == 2) {
          aGraph.addNode(new Node(event.getPoint()));
          // We have changed the model, so now we update
          this.update();
    }*/}
    public void mousePressed(MouseEvent event) { }
    public void mouseReleased(MouseEvent event) { }
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
    }
