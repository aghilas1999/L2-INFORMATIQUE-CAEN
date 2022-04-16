package filRouge;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class DisjunctionConstraint implements Constraint
{
	private Constraint c1, c2;
	
	public DisjunctionConstraint(Constraint c1, Constraint c2)
	{
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule)
	{
		return (this.c1.isSatisfiedBySchedule(schedule) && !this.c2.isSatisfiedBySchedule(schedule) ||
				this.c2.isSatisfiedBySchedule(schedule) && !this.c1.isSatisfiedBySchedule(schedule));
	}
}
