package filRouge;

import java.util.*;

public class MaxSpanConstraint implements Constraint
{
	private ArrayList<Activity> activities;
	private int dureeMax;
	
	public MaxSpanConstraint(ArrayList<Activity> activities, int dureeMax)
	{
		this.activities = new ArrayList<Activity>();
		this.activities.addAll(activities);
		this.dureeMax = dureeMax;
	}

	@Override
	public boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule)
	{
		for(Activity acti : activities)
			if(!schedule.containsKey(acti))
				return false;
		
		int duree = 0;
		
		for(Activity acti : activities)
		{
			duree+=acti.getDuree();
		}
		
		if(duree>this.dureeMax)
			return false;
		
		GregorianCalendar debut, fin, finTmp;
		
		debut = (GregorianCalendar) schedule.get(activities.get(0)).clone();
		fin   = (GregorianCalendar) schedule.get(activities.get(0)).clone();
		fin.add(Calendar.MINUTE, activities.get(0).getDuree());
		
		for(Activity acti : activities)
		{
			if(schedule.get(acti).before(debut))
				debut = (GregorianCalendar) schedule.get(acti).clone();
			
			finTmp = (GregorianCalendar) schedule.get(acti).clone();
			finTmp.add(Calendar.MINUTE, acti.getDuree());
			
			if(fin.before(finTmp))
				fin = (GregorianCalendar) finTmp.clone();
		}
		
		GregorianCalendar finMax = (GregorianCalendar) debut.clone();
		
		finMax.add(Calendar.MINUTE, duree);
		
		return fin.before(finMax);
	}

}
