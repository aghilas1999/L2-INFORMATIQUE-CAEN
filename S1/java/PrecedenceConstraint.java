package filRouge;

import java.util.*;

public class PrecedenceConstraint extends BinaryConstraint
{	
	public PrecedenceConstraint(Activity acti, Activity acti2)
	{
		this.acti  = acti;
		this.acti2 = acti2;
	}
	
	public boolean isSatisfied(GregorianCalendar date1, GregorianCalendar date2)
	{
		date1.add(Calendar.MINUTE, acti.getDuree());
		
		return date1.before(date2);
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule)
	{
		if(!(schedule.containsKey(acti) && schedule.containsKey(acti2)))
			return false;
		
		GregorianCalendar finPremiere = (GregorianCalendar) schedule.get(acti).clone();
		finPremiere.add(Calendar.MINUTE, acti.getDuree());
		
		return finPremiere.before(schedule.get(acti2));
	}
	
	public Activity getActi(int num)
	{
		if(num==1) return acti;
		if(num==2) return acti2;
		
		return null;
	}
	
	public String toString()
	{
		return "Les deux activités " + acti.toString() + " et " + acti2.toString() + " doivent vérifier l'ordre présenté";
	}
}
