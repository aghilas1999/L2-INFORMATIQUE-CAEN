package filRouge;

import java.util.*;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint
{
	private int gap;
	
	public PrecedenceConstraintWithGap(Activity acti, Activity acti2, int duree)
	{
		super(acti, acti2);
		
		this.gap = duree;
	}
	
	public boolean isSatisfied(GregorianCalendar date1, GregorianCalendar date2)
	{
		date1.add(Calendar.MINUTE, super.acti.getDuree());
		date1.add(Calendar.MINUTE, this.gap);
		
		return date1.before(date2);
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule)
	{
		if(!super.isSatisfiedBySchedule(schedule))
			return false;
		
		GregorianCalendar finPremiere = (GregorianCalendar) schedule.get(acti).clone();
		finPremiere.add(Calendar.MINUTE, acti.getDuree());
		
		return finPremiere.before(schedule.get(acti2));
	}
	
	public String toString()
	{
		return super.toString() + " avec un écart de " + this.gap + " minutes";
	}
}
