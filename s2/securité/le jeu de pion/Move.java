package infection;

public class Move{

  private int startX;
  private int endX;
  private int startY;
  private int endY;
  private boolean type;

  public Move(int s, int ss, int e, int ee, boolean t){
    this.startX = s;
    this.endX = e;
    this.startY = ss;
    this.endY = ee;
    this.type = t;
  }

  public int getEndX(){return this.endX;}
  public int getEndY(){return this.endY;}
  public int getStartX(){return this.startX;}
  public int getStartY(){return this.startY;}
  public boolean getType(){return this.type;}

}
