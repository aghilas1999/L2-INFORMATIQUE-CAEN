package filRouge;

import java.util.*;

public class Verifier
{
	private ArrayList<Constraint> constraintList;
	
	public Verifier()
	{
		this.constraintList = new ArrayList<Constraint>();
	}
	
	public void add(Constraint constraint)
	{
		this.constraintList.add(constraint);
	}
	
	public String notOkCons(HashMap<Activity, GregorianCalendar> schedule)
	{
		String notOkCons = "La ou les contrainte(s) suivante(s) ne sont pas satisfaite(s) :";
		
		for(Constraint c : this.constraintList)
			if(!c.isSatisfiedBySchedule(schedule))
				notOkCons+=c.toString() + "\n\n";
		
		return notOkCons;
	}
	
	public boolean verify(HashMap<Activity, GregorianCalendar> schedule)
	{
		for(Constraint c : this.constraintList)
			if(!c.isSatisfiedBySchedule(schedule))
				return false;
		
		return true;
	}
}
