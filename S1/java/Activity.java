package filRouge;

import java.util.*;

public class Activity
{
	private String description;
	private GregorianCalendar debut;
	private int    duree;
	
	public Activity(String desc, GregorianCalendar debut, int duree)
	{
		this.description = desc;
		this.debut       = debut;
		this.duree       = duree;
	}
	
	public Activity(String desc, int duree)
	{
		this(desc, null, duree);
	}
	
	public Activity(Activity b)
	{
		this.description = b.getDescription();
		this.debut = b.getDebut();
		this.duree = b.getDuree();
	}

	public void setDebut(GregorianCalendar debut)
	{
		this.debut = debut;
	}
	
	public GregorianCalendar getDebut()
	{
		if(debut==null) return new GregorianCalendar(1,1,1,1,1);
		
		return debut;
	}
	
	public GregorianCalendar getFin()
	{
		if(debut==null) return new GregorianCalendar(1,1,1,1,1);
		
		GregorianCalendar fin = new GregorianCalendar(debut.get(Calendar.YEAR), debut.get(Calendar.MONTH), debut.get(Calendar.DAY_OF_MONTH),
													  debut.get(Calendar.HOUR_OF_DAY), debut.get(Calendar.MINUTE), debut.get(Calendar.SECOND));
		                       
		fin.add(Calendar.MINUTE, duree);
		
		return fin;
	}

	public String getDescription() { return this.description; }
	public int getDuree() { return this.duree; }
	
	public String toString()
	{
		return this.description + (this.debut==null?"":" : " + this.debut.get(Calendar.YEAR) + "-" + this.debut.get(Calendar.MONTH) + 
									"-" + this.debut.get(Calendar.DAY_OF_WEEK) +
									":" + this.debut.get(Calendar.HOUR_OF_DAY) + "h" + this.debut.get(Calendar.MINUTE));
	}
}
